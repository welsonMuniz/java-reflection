package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {

    @Override
    public BigDecimal somar(Object object) {
        return calcularValores(object, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object object) {
        return calcularValores(object, Subtrair.class);
    }

    @Override
    public BigDecimal totalizar(Object object) {
        return somar(object).subtract(subtrair(object));
    }

    private BigDecimal calcularValores(Object obj, Class<? extends Annotation> annotation) {
        BigDecimal vlrCalculado = BigDecimal.ZERO;
        Field[] fields = obj.getClass().getDeclaredFields();
        try{
            for (Field field : fields){
                field.setAccessible(true);
                if(field.isAnnotationPresent((annotation))){
                    vlrCalculado = vlrCalculado.add((BigDecimal) field.get(obj));
                }
            }
        } catch (IllegalAccessException e){
            System.out.println(e.getMessage());
        }
        return vlrCalculado;
    }
}