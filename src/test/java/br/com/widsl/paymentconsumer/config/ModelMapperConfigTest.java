package br.com.widsl.paymentconsumer.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DisplayName("ModelMapperConfig Test")
@ContextConfiguration(classes = ModelMapperConfig.class)
class ModelMapperConfigTest {

    private ModelMapperConfig modelMapperConfig;

    @BeforeEach
    void setup() {
        modelMapperConfig = new ModelMapperConfig();
    }

    @Test
    @DisplayName("Should return a new instance of ModelMapper")
    void modelMapperReturnsNewInstance() {
        ModelMapper modelMapper = modelMapperConfig.modelMapper();

        assertNotNull(modelMapper);
    }

}