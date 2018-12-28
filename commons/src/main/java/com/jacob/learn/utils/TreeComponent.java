package com.jacob.learn.utils;

import com.jacob.learn.tree.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

@Slf4j
@Component
public class TreeComponent {
    /**
     * 获取新节点
     * @return
     */
    public TreeNode node(){
        return new TreeNode();
    }

    /**
     * 获取Root节点
     * @return
     */
    public TreeNode root(){
        TreeNode node = new TreeNode();
        node.setId(0L);
        node.setName("所有分组");
        node.setDescribes("所有分组");
        node.setParentId(-1L);
        return node;
    }

    /**
     * 转换为Tree结构
     * @param nodes
     * @return
     */
    public TreeNode build(List<TreeNode> nodes){
        TreeNode root = null;
        for(TreeNode node : nodes){
            if(node.getParentId() == -1) {
                root = node;
            }
            TreeNode parent = getParentNode(nodes, node);
            if(parent != null){
                parent.getChildren().add(node);
            }
        }
        return root;
    }

    /**
     * 获得指定节点的父节点
     * @param list
     * @paraam node
     * @return
     */
    private TreeNode getParentNode(List<TreeNode> list, TreeNode node){
        for(TreeNode item : list){
            if(item.getId() == node.getParentId()) {
                return item;
            }
        }
        return null;
    }

    /**
     * 查找指定节点的所有的子节点
     * @return
     */
    public Set<TreeNode> queryAllNode(TreeNode node) {
        Set<TreeNode> nodes = new HashSet<>();
        addAllNodes(node, nodes);
        return nodes;
    }

    /**
     * 递归添加子节点
     * @param node
     * @param ret
     */
    private void addAllNodes(TreeNode node, Collection<TreeNode> ret) {
        if (node != null) {
            ret.add(node);
            List<TreeNode> children = node.getChildren();
            if (children != null) {
                for (TreeNode child: children) {
                    addAllNodes(child, ret);
                }
            }
        }
    }

    /**
     * 从所有的分组中得到指定节点的所有子节点（含自己）
     * @param treeNode
     * @param groupId
     * @return
     */
    public Set<Long> queryGroupInfos(TreeNode treeNode, Long groupId) {
        Set<Long> ret = new HashSet<>();
        //从所有的分组中得到指定节点的所有子节点（含自己）
        if (treeNode != null) {
            TreeNode srcNode = findNode(treeNode, groupId);
            Set<TreeNode> nodes = queryAllNode(srcNode);

            for (TreeNode node : nodes) {
                ret.add(node.getId());
            }
        }
        return ret;
    }

    /**
     *
     * @param
     * @param
     * @return
     */
    public TreeNode findNode(TreeNode node, Long id) {
        if (node.getId() == id) {
            return node;
        } else {
            List<TreeNode> children = node.getChildren();
            for (TreeNode child : children) {
                TreeNode ret = findNode(child, id);
                if (ret != null) {
                    return ret;
                }
            }
        }
        return null;
    }
}