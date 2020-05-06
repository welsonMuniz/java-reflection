package com.challenge.testes;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.desafio.CalculadorDeClasses;

import java.math.BigDecimal;

public class TesteReflection {

    @Subtrair
    private BigDecimal subtrair1 = BigDecimal.valueOf(5000);

    public BigDecimal subtrair2 = BigDecimal.valueOf(5000);

    private BigDecimal somar1 = BigDecimal.valueOf(5000);

    @Somar
    public BigDecimal somar2 = BigDecimal.valueOf(6000);

    public static void main(String[] args) {
        TesteReflection tr = new TesteReflection();
        CalculadorDeClasses cc = new CalculadorDeClasses();

        System.out.println(cc.somar(tr));
        System.out.println(cc.subtrair(tr));
        System.out.println(cc.totalizar(tr));
    }
}
