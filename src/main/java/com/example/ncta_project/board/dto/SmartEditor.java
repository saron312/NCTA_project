package com.example.ncta_project.board.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SmartEditor {

    private String sFileURL;
    private String sFileName;
    private String bNewLine;

}