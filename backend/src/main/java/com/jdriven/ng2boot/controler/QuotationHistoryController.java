package com.jdriven.ng2boot.controler;

import com.jdriven.ng2boot.domain.QuotationHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jdriven.ng2boot.repository.QuotationHistoryRepository;

import java.util.Date;

@Controller
public class QuotationHistoryController {

    @Autowired
    private QuotationHistoryRepository QuotationHistoryRepository;

    @RequestMapping("/quotation-history")
    @ResponseBody
    public String test() {
        QuotationHistory quotation = new QuotationHistory();
        quotation.setDate(new Date(2017, 06, 14));
        quotation.setOpen(10D);
        quotation.setHigh(15D);
        quotation.setLow(7D);
        quotation.setClose(9D);
        quotation.setVolume(100);
        quotation.setFK_Quotation(2L);
        QuotationHistoryRepository.save(quotation);
        QuotationHistory r2 = QuotationHistoryRepository.findOne(quotation.getId());
        System.out.println("Quotation History " + r2.getFK_Quotation() + " added!");
        QuotationHistoryRepository.delete(quotation);
        System.out.println("Quotation History " + r2.getFK_Quotation() + " deleted!");
        return "OK!";
    }
}
