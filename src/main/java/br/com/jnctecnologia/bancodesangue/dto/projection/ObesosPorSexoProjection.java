package br.com.jnctecnologia.bancodesangue.dto.projection;

public interface ObesosPorSexoProjection {
    String getSexo();
    Long getTotal();
    Long getObesos();
    Double getPercentual();
}
