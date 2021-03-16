package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pt.iscte.hospital.entities.Message;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.services.MessageService;
import pt.iscte.hospital.services.user.UserService;

import java.util.List;

@Controller
public class MessageController {
    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;

    @GetMapping(value = "/{userType}/messages")
    public String verMensagens(ModelMap modelMap,
                               @PathVariable(value = "userType") String userType) {

        List<Message> messages = messageService.findAllByUserUserIdOrderByDateTimeDesc(currentUser().getUserId());
        System.out.println(messages);
        modelMap.put("user_logged", currentUser());
        modelMap.put("messages", messages);
        modelMap.put("userType", userType);
        return "user/message-list";
    }

    @GetMapping(value = "/{userType}/messages/delete/{messageId}")
    public String deleteMensagem(ModelMap modelMap,
                                 @PathVariable(value = "userType") String userType,
                                 @PathVariable(value = "messageId") Long messageId) {

        messageService.deleteMessageById(messageId);

        return "redirect:/" + userType + "/messages";
    }

    @GetMapping(value = "/{userType}/messages/read/{messageId}")
    public String markHasReadMensagens(ModelMap modelMap,
                                       @PathVariable(value = "userType") String userType,
                                       @PathVariable(value = "messageId") Long messageId) {

        messageService.markMessageHasReadById(messageId);

        return "redirect:/" + userType + "/messages";
    }

    // Private Methods
    private User currentUser() {
        return userService.currentUser();
    }

}
