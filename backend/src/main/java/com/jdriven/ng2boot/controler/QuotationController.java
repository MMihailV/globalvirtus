package com.jdriven.ng2boot.controler;

import com.jdriven.ng2boot.domain.Quotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jdriven.ng2boot.repository.QuotationRepository;

@Controller
public class QuotationController {

    @Autowired
    private QuotationRepository QuotationRepository;

    @RequestMapping("/quotation")
    @ResponseBody
    public String test() {
        Quotation quotation = new Quotation();
        quotation.setQuotationName("YUTB");
        quotation.setQuotationLink("http://stok.com/quotation/yutb");
        QuotationRepository.save(quotation);
        Quotation r2 = QuotationRepository.findOne(quotation.getId());
        System.out.println("Quotation " + r2.getQuotationName() + " added!");
        QuotationRepository.delete(quotation);
        System.out.println("Quotation " + r2.getQuotationName() + " deleted!");
        return "OK!";
    }
}
