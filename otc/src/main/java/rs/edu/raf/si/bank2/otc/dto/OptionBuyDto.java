package rs.edu.raf.si.bank2.otc.dto;

import lombok.Data;

@Data
public class OptionBuyDto {

    private Long optionId;
    private int amount;
    private double premium;
}