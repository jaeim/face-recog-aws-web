package model;

public class Setting {
	private int STG_ID;
	private int DETEC_SEC;
	private int NOD_SEC;
	private int RECOG_LV;
	
	public Setting() {
		
	}
	
	public Setting(int sTG_ID, int dETEC_SEC, int nOD_SEC, int rECOG_LV) {
		super();
		STG_ID = sTG_ID;
		DETEC_SEC = dETEC_SEC;
		NOD_SEC = nOD_SEC;
		RECOG_LV = rECOG_LV;
	}
	
	public int getSTG_ID() {
		return STG_ID;
	}
	public void setSTG_ID(int sTG_ID) {
		STG_ID = sTG_ID;
	}
	public int getDETEC_SEC() {
		return DETEC_SEC;
	}
	public void setDETEC_SEC(int dETEC_SEC) {
		DETEC_SEC = dETEC_SEC;
	}
	public int getNOD_SEC() {
		return NOD_SEC;
	}
	public void setNOD_SEC(int nOD_SEC) {
		NOD_SEC = nOD_SEC;
	}
	public int getRECOG_LV() {
		return RECOG_LV;
	}
	public void setRECOV_LV(int rECOG_LV) {
		RECOG_LV = rECOG_LV;
	}
	
}
