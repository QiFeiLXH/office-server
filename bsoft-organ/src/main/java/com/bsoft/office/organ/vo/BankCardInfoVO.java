package com.bsoft.office.organ.vo;

import lombok.Data;

@Data
public class BankCardInfoVO {
    private Integer id;
    /** 是否需办卡 */
    private Integer needApplyCard;
    //银行卡照片
    private Integer backCardPhoto;
    /** 开户银行 */
    private String depositBank;

    /** 银行账号 */
    private String bankAccount;

    /** 开户支行 */
    private String openingBank;
    /** 一寸照 */
    private Integer oneInchPhoto;
    /** 状态*/
    private Integer status;
}
