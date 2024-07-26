package com.example.mypkg.service;


import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.mypkg.model.FormData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@Service
public class FormDataService {

    private static final String FILE_PATH = "formData.json";

    public List<FormData> getAllFormData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(FILE_PATH);
        if (file.exists() && file.length() > 0) {
            return mapper.readValue(file, new TypeReference<List<FormData>>() {});
        }
        return new ArrayList<>();
    }

    public FormData saveFormData(FormData formData) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer().with(SerializationFeature.INDENT_OUTPUT);
        File file = new File(FILE_PATH);

        List<FormData> formDataList = getAllFormData();
        formDataList.add(formData);

        writer.writeValue(file, formDataList);
        return formData;
    }
}
