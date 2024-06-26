package br.com.fiap.tapago.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.fiap.tapago.validation.TipoMovimentacao;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class CamisaDeTimeApplication {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "{Camisa.De.Time.notblank}")
    @Size(min = 3, max = 255)
    private String descricao;

    @Positive
    private BigDecimal valor;

    private LocalDate data;

    @TipoMovimentacao
    private String tipo; //ENTRADA | SAIDA
    
}

