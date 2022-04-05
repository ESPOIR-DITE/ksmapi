package com.example.ksmapi.controller.sell;

import com.example.ksmapi.controller.ControllerInterface;
import com.example.ksmapi.domain.sell.Sell;
import com.example.ksmapi.domain.sell.SellPeriod;
import com.example.ksmapi.domain.sell.SellPrice;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface SellPeriodController extends ControllerInterface<SellPeriod,String> {
    ResponseEntity<List<SellPeriod>> findAllByPeriodId(String periodId, HttpServletRequest request);
}
