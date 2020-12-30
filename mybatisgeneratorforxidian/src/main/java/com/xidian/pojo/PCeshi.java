package com.xidian.pojo;

import javax.persistence.*;

@Table(name = "p_ceshi")
public class PCeshi {
    @Id
    private Integer id;

    @Column(name = "wos_cited")
    private Integer wosCited;

    private String publisher;

    private String issn;

    private String eissn;

    @Column(name = "journal_iso")
    private String journalIso;

    @Column(name = "pub_year")
    private String pubYear;

    private String volume;

    private String issue;

    @Column(name = "start_page")
    private String startPage;

    @Column(name = "end_page")
    private String endPage;

    @Column(name = "article_num")
    private String articleNum;

    private String doi;

    @Column(name = "research_areas")
    private String researchAreas;

    private String ids;

    private String ut;

    /**
     * 标识位用于软删除
     */
    private String flag;

    private String title;

    @Column(name = "authors_fullname")
    private String authorsFullname;

    @Column(name = "source_title")
    private String sourceTitle;

    private String keywords;

    private String abstracts;

    private String addresses;

    private String emails;

    @Column(name = "orc_ids")
    private String orcIds;

    @Column(name = "found_org")
    private String foundOrg;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return wos_cited
     */
    public Integer getWosCited() {
        return wosCited;
    }

    /**
     * @param wosCited
     */
    public void setWosCited(Integer wosCited) {
        this.wosCited = wosCited;
    }

    /**
     * @return publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @param publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * @return issn
     */
    public String getIssn() {
        return issn;
    }

    /**
     * @param issn
     */
    public void setIssn(String issn) {
        this.issn = issn;
    }

    /**
     * @return eissn
     */
    public String getEissn() {
        return eissn;
    }

    /**
     * @param eissn
     */
    public void setEissn(String eissn) {
        this.eissn = eissn;
    }

    /**
     * @return journal_iso
     */
    public String getJournalIso() {
        return journalIso;
    }

    /**
     * @param journalIso
     */
    public void setJournalIso(String journalIso) {
        this.journalIso = journalIso;
    }

    /**
     * @return pub_year
     */
    public String getPubYear() {
        return pubYear;
    }

    /**
     * @param pubYear
     */
    public void setPubYear(String pubYear) {
        this.pubYear = pubYear;
    }

    /**
     * @return volume
     */
    public String getVolume() {
        return volume;
    }

    /**
     * @param volume
     */
    public void setVolume(String volume) {
        this.volume = volume;
    }

    /**
     * @return issue
     */
    public String getIssue() {
        return issue;
    }

    /**
     * @param issue
     */
    public void setIssue(String issue) {
        this.issue = issue;
    }

    /**
     * @return start_page
     */
    public String getStartPage() {
        return startPage;
    }

    /**
     * @param startPage
     */
    public void setStartPage(String startPage) {
        this.startPage = startPage;
    }

    /**
     * @return end_page
     */
    public String getEndPage() {
        return endPage;
    }

    /**
     * @param endPage
     */
    public void setEndPage(String endPage) {
        this.endPage = endPage;
    }

    /**
     * @return article_num
     */
    public String getArticleNum() {
        return articleNum;
    }

    /**
     * @param articleNum
     */
    public void setArticleNum(String articleNum) {
        this.articleNum = articleNum;
    }

    /**
     * @return doi
     */
    public String getDoi() {
        return doi;
    }

    /**
     * @param doi
     */
    public void setDoi(String doi) {
        this.doi = doi;
    }

    /**
     * @return research_areas
     */
    public String getResearchAreas() {
        return researchAreas;
    }

    /**
     * @param researchAreas
     */
    public void setResearchAreas(String researchAreas) {
        this.researchAreas = researchAreas;
    }

    /**
     * @return ids
     */
    public String getIds() {
        return ids;
    }

    /**
     * @param ids
     */
    public void setIds(String ids) {
        this.ids = ids;
    }

    /**
     * @return ut
     */
    public String getUt() {
        return ut;
    }

    /**
     * @param ut
     */
    public void setUt(String ut) {
        this.ut = ut;
    }

    /**
     * 获取标识位用于软删除
     *
     * @return flag - 标识位用于软删除
     */
    public String getFlag() {
        return flag;
    }

    /**
     * 设置标识位用于软删除
     *
     * @param flag 标识位用于软删除
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return authors_fullname
     */
    public String getAuthorsFullname() {
        return authorsFullname;
    }

    /**
     * @param authorsFullname
     */
    public void setAuthorsFullname(String authorsFullname) {
        this.authorsFullname = authorsFullname;
    }

    /**
     * @return source_title
     */
    public String getSourceTitle() {
        return sourceTitle;
    }

    /**
     * @param sourceTitle
     */
    public void setSourceTitle(String sourceTitle) {
        this.sourceTitle = sourceTitle;
    }

    /**
     * @return keywords
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * @param keywords
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * @return abstracts
     */
    public String getAbstracts() {
        return abstracts;
    }

    /**
     * @param abstracts
     */
    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    /**
     * @return addresses
     */
    public String getAddresses() {
        return addresses;
    }

    /**
     * @param addresses
     */
    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    /**
     * @return emails
     */
    public String getEmails() {
        return emails;
    }

    /**
     * @param emails
     */
    public void setEmails(String emails) {
        this.emails = emails;
    }

    /**
     * @return orc_ids
     */
    public String getOrcIds() {
        return orcIds;
    }

    /**
     * @param orcIds
     */
    public void setOrcIds(String orcIds) {
        this.orcIds = orcIds;
    }

    /**
     * @return found_org
     */
    public String getFoundOrg() {
        return foundOrg;
    }

    /**
     * @param foundOrg
     */
    public void setFoundOrg(String foundOrg) {
        this.foundOrg = foundOrg;
    }
}