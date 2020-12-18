package com.imooc.pojo.vo;

import java.util.List;

/**
 * 二级分类VO
 */
public class CategoryVO {
    /**
     * SELECT
     *         f.id as id,
     *         f.`name` as `name`,
     *         f.type as type,
     *         f.father_id as fatherId,
     *         c.id as subId,
     *         c.`name` as subName,
     *         c.type as subType,
     *         c.father_id as subFatherId
     *       FROM
     *         category f
     *       LEFT JOIN
     *         category c
     *       ON
     *         f.id = c.father_id
     *       WHERE
     *         f.father_id = #{rootCatId}
     */
    private Integer id;
    private String name;
    private String type;
    private Integer fatherId;
    // 三级分类vo List
    private List<SubCategoryVO> subCatList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    public List<SubCategoryVO> getSubCatList() {
        return subCatList;
    }

    public void setSubCatList(List<SubCategoryVO> subCatList) {
        this.subCatList = subCatList;
    }
}
