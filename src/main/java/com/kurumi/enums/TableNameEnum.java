package com.kurumi.enums;

public enum TableNameEnum {

	Sex("性别","sex"),Marriage("婚姻","marriage"),Profession("职业","profession"),RelativeRelation("亲属关系","relative_relation"),
	Nationality("国籍","nationality"),Nation("民族","nation"),MrPageType("编页标签","mr_page_type"),
	MrPrinterType("打印类型","mr_printer_type"),MedicalPaymentType("付费方式","medical_payment_type"),IdentityDocumentType("证件类型","identity_document_type"),
	InHospitalType("入院方式","in_hospital_type"),InHospitalizationState("入院病情","in_hospitalization_state"),OutHospitalType("离院方式","out_hospital_type"),
	BloodType("ABO血型","blood_type"),RhBloodType("RH血型","rh_blood_type"),DiagnosticCoincidenceType("诊断符合","diagnostic_coincidence_type"),
	DiagnoseType("诊断类型","diagnose_type"),TreatmentResult("治疗结果","treatment_result"),InHospitalizationDiseaseState("诊断状况","in_hospitalization_disease_state"),
	StdIncisionLevel("切口等级","std_incision_level"),StdCicatrizationType("愈合类别","std_cicatrization_type"),StdOpsLevel("切口等级","std_ops_level"),
	StdAnaesthesiaWay("麻醉方式","std_anaesthesia_way"),StdAnaesthesiaLevel("麻醉（ASA）分级","std_anaesthesia_level"),BodyPart("身体部位","body_part"),
	RehospitalizationAim("再住院目的","rehospitalization_aim"),HospitalizationDealthReason("死亡原因","hospitalization_dealth_reason"),StdOpsMark("手术标识","std_ops_mark"),
	Hospital("医院","hospital"); 
	
	// 成员变量  
    private String tableNameDesc;  
    private String tableName;
    
	private TableNameEnum(String tableNameDesc, String tableName) {
		this.tableNameDesc = tableNameDesc;
		this.tableName = tableName;
	}

	public String getTableNameDesc() {
		return tableNameDesc;
	}

	public void setTableNameDesc(String tableNameDesc) {
		this.tableNameDesc = tableNameDesc;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}  
    
}
