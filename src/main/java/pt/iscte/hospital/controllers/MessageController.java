package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pt.iscte.hospital.entities.Message;
import pt.iscte.hospital.services.MessageService;
import pt.iscte.hospital.controllers.utils.Common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class MessageController {
    private final Common common;
    private final MessageService messageService;

    @Autowired
    public MessageController(Common common, MessageService messageService) {
        this.common = common;
        this.messageService = messageService;
    }

    @GetMapping(value = "/{userType}/messages")
    public String verMensagens(ModelMap modelMap,
                               @PathVariable(value = "userType") String userType) {

        List<Message> messages = messageService.findAllByUserUserIdOrderByDateDesc(common.currentUser().getUserId());

        modelMap.put("messages", messages);
        modelMap.put("userType", userType);
        modelMap.addAllAttributes(common.sideNavMap());
        return "user/message-list";
    }

    @PostMapping(value = "/{userType}/messages")
    public String verFiltrarMensagens(ModelMap modelMap,
                                      @PathVariable(value = "userType") String userType,
                                      @RequestParam(required = false, value = "dateSrc") String dateScr,
                                      @RequestParam(required = false, value = "msgStateSrc") String msgStateSrc) {

        Long userId = common.currentUser().getUserId();
        // resultado da pesquisa
        List<Message> messages;
        boolean hasRead = false;

        LocalDate date = null;
        if(dateScr != null && !dateScr.isEmpty()){
            date = LocalDate.parse(dateScr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }

        // pesquisa sem requisitos
        if ((dateScr == null || dateScr.isEmpty()) && (msgStateSrc == null || msgStateSrc.equals("all"))) {
            messages = messageService.findAllByUserUserIdOrderByDateDesc(userId);

            // pesquisa por estado
        } else if ((dateScr == null || dateScr.isEmpty()) && msgStateSrc != null) {
            if (msgStateSrc.equals("open")) {
                hasRead = true;
            }
            messages = messageService.findAllByUserUserIdAndReadMsgOrderByDateDesc(userId, hasRead);
        } else // pesquisa por data e todos os estados
            if ((msgStateSrc == null || msgStateSrc.equals("all"))) {
                messages = messageService.findAllByUserUserIdAndDateOrderByDateDesc(userId, date);
            } else {
                if (msgStateSrc.equals("open")) {
                    hasRead = true;
                }
                messages = messageService.findAllByUserUserIdAndDateAndReadMsgOrderByDateDesc(userId, date, hasRead);
            }

        modelMap.put("messages", messages);
        modelMap.put("userType", userType);
        modelMap.addAllAttributes(common.sideNavMap());
        return "user/message-list";
    }

    @GetMapping(value = "/{userType}/messages/delete/{messageId}")
    public String deleteMensagem(@PathVariable(value = "userType") String userType,
                                 @PathVariable(value = "messageId") Long messageId) {

        messageService.deleteMessageById(messageId);

        return "redirect:/" + userType + "/messages";
    }

    @GetMapping(value = "/{userType}/messages/read/{messageId}")
    public String markHasReadMensagens(@PathVariable(value = "userType") String userType,
                                       @PathVariable(value = "messageId") Long messageId) {

        messageService.markMessageHasReadById(messageId);

        return "redirect:/" + userType + "/messages";
    }

    // Private Methods


}
