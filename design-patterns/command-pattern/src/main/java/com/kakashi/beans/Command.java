package com.kakashi.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Command {

    private String name;
    private List<String> params;
}
