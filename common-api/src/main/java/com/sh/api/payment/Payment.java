package com.sh.api.payment;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 支付
 *
 *
 * @author 盛浩
 * @date 2020/12/25 20:55
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Payment extends Model<Payment> {

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 支付流水号
     */
    private String serial;
}
