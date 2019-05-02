package ru.itprogram.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.itprogram.entity.dto.BrandDto;
import ru.itprogram.entity.dto.ProductDto;
import ru.itprogram.entity.dto.ProductTypeDto;
import ru.itprogram.entity.dto.PromoCodeDto;
import ru.itprogram.service.ProductService;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadProductInFile {
    public static final String PATH = "ProductList";
    private static final String TRANSITION_TO_A_NEW_LINE = "\n";
    private static final String BY_STRAIGHT_LINE = "\\|";
    private static Logger logger;
    private StringBuilder stringBuilder;

    public ReadProductInFile() {
        logger = LoggerFactory.getLogger(ReadProductInFile.class);
        stringBuilder = new StringBuilder();
    }

    public void readFile(String pathFile) {
        try {
            FileReader fileReader = new FileReader(PATH);
            int c;
            while ((c = fileReader.read()) != -1) {
                stringBuilder.append((char) c);
            }
            fileReader.close();
            writeDb();
        } catch (java.io.IOException e) {
            logger.warn(e.getMessage(), e);
        }
    }

    private void writeDb() {
        List<String> strings = new ArrayList<>();
        for (String s : stringBuilder.toString().split(TRANSITION_TO_A_NEW_LINE)) {
            strings.add(s);
        }
        for (String s : strings) {
            new ProductService().add(new ProductDto(0, new BrandDto(s.split(BY_STRAIGHT_LINE)[0]),
                    new ProductTypeDto(s.split(BY_STRAIGHT_LINE)[1]),
                    s.split(BY_STRAIGHT_LINE)[2],
                    Integer.valueOf(s.split(BY_STRAIGHT_LINE)[3]),
                    Short.valueOf(s.split(BY_STRAIGHT_LINE)[4]),
                    Boolean.valueOf(s.split(BY_STRAIGHT_LINE)[5]),
                    Double.valueOf(s.split(BY_STRAIGHT_LINE)[6]),
                    new PromoCodeDto(s.split(BY_STRAIGHT_LINE)[7],
                            Short.valueOf(s.split(BY_STRAIGHT_LINE)[8]))));
        }
    }
}
