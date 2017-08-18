package com.codelib.springboot.sample.mybatis.pojo;

import java.io.Serializable;

public class Course implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column courses.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column courses.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column courses.textbook_id
     *
     * @mbg.generated
     */
    private Integer textbookId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column courses.grade_id
     *
     * @mbg.generated
     */
    private Integer gradeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table courses
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    private Textbook textbook;
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table courses
     *
     * @mbg.generated
     */
    public Course(Integer id, String name, Integer textbookId, Integer gradeId) {
        this.id = id;
        this.name = name;
        this.textbookId = textbookId;
        this.gradeId = gradeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table courses
     *
     * @mbg.generated
     */
    public Course() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column courses.id
     *
     * @return the value of courses.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column courses.id
     *
     * @param id the value for courses.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column courses.name
     *
     * @return the value of courses.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column courses.name
     *
     * @param name the value for courses.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column courses.textbook_id
     *
     * @return the value of courses.textbook_id
     *
     * @mbg.generated
     */
    public Integer getTextbookId() {
        return textbookId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column courses.textbook_id
     *
     * @param textbookId the value for courses.textbook_id
     *
     * @mbg.generated
     */
    public void setTextbookId(Integer textbookId) {
        this.textbookId = textbookId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column courses.grade_id
     *
     * @return the value of courses.grade_id
     *
     * @mbg.generated
     */
    public Integer getGradeId() {
        return gradeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column courses.grade_id
     *
     * @param gradeId the value for courses.grade_id
     *
     * @mbg.generated
     */
    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Textbook getTextbook() {
		return textbook;
	}

	public void setTextbook(Textbook textbook) {
		this.textbook = textbook;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table courses
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Course other = (Course) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getTextbookId() == null ? other.getTextbookId() == null : this.getTextbookId().equals(other.getTextbookId()))
            && (this.getGradeId() == null ? other.getGradeId() == null : this.getGradeId().equals(other.getGradeId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table courses
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTextbookId() == null) ? 0 : getTextbookId().hashCode());
        result = prime * result + ((getGradeId() == null) ? 0 : getGradeId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table courses
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", textbookId=").append(textbookId);
        sb.append(", gradeId=").append(gradeId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}