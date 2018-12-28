package com.jacob.learn.tree;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class TreeNode {
    private Long id;

    private String name;

    private String describes;

    private Long parentId;

    private List<TreeNode> children = new ArrayList<>();
}
