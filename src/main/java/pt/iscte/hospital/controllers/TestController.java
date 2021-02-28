package pt.iscte.hospital.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping(value = "/test")
    public String pageTest() {
        return "test";
    }

    @GetMapping(value = "/faturaForm")
    public String pageFaturaForm() {
        return "faturaForm";
    }

    @GetMapping(value = "/historicoPagamentos")
    public String page() {
        return "historicoPagamentos";
    }

    @GetMapping(value = "/lista-utentes")
    public String showDoctorUtentes(ModelMap modelMap) {
        return "lista-utentes";
    }
}
