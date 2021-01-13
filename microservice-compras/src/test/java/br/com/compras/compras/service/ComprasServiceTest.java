package br.com.compras.compras.service;

import br.com.compras.compras.model.Compra;
import br.com.compras.compras.repository.CompraRepository;
import br.com.compras.compras.service.CompraService;
import br.com.compras.compras.service.CompraServiceImpl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class ComprasServiceTest {

    CompraService service;

    @MockBean
    CompraRepository repository;

    @BeforeEach
    public void setUp() {
        this.service = new CompraServiceImpl(repository);
    }

    @Test
    @DisplayName("Deve criar uma compra")
    public void saveCompraTest() {
        // cenário
        Compra compra = createValidCompra();
        Mockito.when(repository.existsById(Mockito.anyString())).thenReturn(false);

        Mockito.when(repository.save(compra)).thenReturn(Compra.builder()
                .id(String.valueOf(1))
                .dataCompra(LocalDate.now())
                .descricao("laptop")
                .categoria("eletronicos")
                .valor(BigDecimal.valueOf(5000.0))
                .build());

        // execução
        Compra savedCompra = service.create(compra);

        // verificação
        Assertions.assertThat(savedCompra.getId()).isNotNull();
        Assertions.assertThat(savedCompra.getValor()).isEqualTo(BigDecimal.valueOf(5000.0));
        Assertions.assertThat(savedCompra.getDescricao()).isEqualTo("laptop");
        Assertions.assertThat(savedCompra.getCategoria()).isEqualTo("eletronicos");
        Assertions.assertThat(savedCompra.getDataCompra()).isEqualTo(LocalDate.now());
    }

    public Compra createValidCompra() {
        return Compra.builder()
                .dataCompra(LocalDate.now())
                .categoria("laptop")
                .descricao("eletronicos")
                .valor(BigDecimal.valueOf(30.0))
                .build();
    }

    @Test
    @DisplayName("Deve obter compra por Id")
    public void getByIdTest() {
        // cenário
        String id = "1";

        Compra compra = createValidCompra();
        compra.setId(id);
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(compra));

        // execução
        Optional<Compra> foundCompra = Optional.ofNullable(service.findById(id));

        // verificação
        Assertions.assertThat(foundCompra.isPresent()).isTrue();
        Assertions.assertThat(foundCompra.get().getValor()).isEqualTo(BigDecimal.valueOf(5000.0));
        Assertions.assertThat(foundCompra.get().getDescricao()).isEqualTo("laptop");
        Assertions.assertThat(foundCompra.get().getCategoria()).isEqualTo("eletronicos");
        Assertions.assertThat(foundCompra.get().getDataCompra()).isEqualTo(LocalDate.now());
    }

    @Test
    @DisplayName("Deve deletar uma compra")
    public void deleteCompraTest() {
        // cenário
        Compra compra = Compra.builder().id("1").build();

        // execução
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(() -> service.delete(compra));

        // verificação
        Mockito.verify(repository, Mockito.times(1)).delete(compra);
    }

    @Test
    @DisplayName("Deve atualizar uma compra")
    public void updateCompraTest() {
        // cenário
        String id = "1";

        // compra a atualizar
        Compra updatingCompra = Compra.builder().id(id).build();

        // simulação
        Compra updatedCompra = createValidCompra();
        updatedCompra.setId(id);

        Mockito.when(repository.save(updatingCompra)).thenReturn(updatedCompra);

        // execução
        Compra compra = service.update(updatingCompra);

        // verificações
        Assertions.assertThat(compra.getId()).isEqualTo(updatedCompra.getId());
        Assertions.assertThat(compra.getValor()).isEqualTo(updatedCompra.getValor());
        Assertions.assertThat(compra.getDescricao()).isEqualTo(updatedCompra.getDescricao());
        Assertions.assertThat(compra.getCategoria()).isEqualTo(updatedCompra.getCategoria());
        Assertions.assertThat(compra.getDataCompra()).isEqualTo(updatedCompra.getDataCompra());
    }
}
