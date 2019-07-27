package cli;

public class Plant {
	// Use Integer than int for null or " " values
	private Integer entryNo,DTA,DTS,GW,earHvst,Rlodg,Slodg,repNo,plotNo,column,row;
	private String gid,designation,plantingDate,entryType;
	private Float EH, PH,MOI;

	
	/**
	 * 
	 * @param gid
	 */
	public Plant(PlantBuilder builder) {
		this.gid = builder.gid;
		this.entryNo = builder.entryNo;
		this.DTA = builder.DTA;
		this.DTS = builder.DTS;
		this.GW = builder.GW;
		this.earHvst = builder.earHvst;
		this.Rlodg = builder.Rlodg;
		this.Slodg = builder.Slodg;
		this.repNo = builder.repNo;
		this.plotNo = builder.plotNo;
		this.column = builder.column;
		this.row = builder.row;
		this.designation = builder.designation;
		this.plantingDate = builder.plantingDate;
		this.entryType = builder.entryType;
		this.EH = builder.EH;
		this.PH = builder.PH;
		this.MOI = builder.MOI;
		
		
		
	}
	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public String getGid() {
		
		return this.gid;
		
	}
	
	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public String getPlantingDate() {

		return this.plantingDate;

	}
	

	/**
	 * 
	 * @param gid
	 * @return
	 */
	public String getEntryType() {

		return this.entryType;

	}
	

	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public String getDesignation() {
		return this.designation;
	}
	
	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public Integer getEntryNo() {

		return this.entryNo;

	}
	

	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public Float getEH() {

		return this.EH;

	}
	
	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public Float getPH() {

		return this.PH;

	}
	

	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public Integer getDTA() {

		return this.DTA;

	}
	

	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public Integer getDTS() {

		return this.DTS;

	}
	

	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public Float getMOI() {

		return this.MOI;

	}
	

	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public Integer getGW() {

		return this.GW;

	}
	

	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public Integer getEarHvst() {

		return this.earHvst;

	}
	

	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public Integer getRlodg() {

		return this.Rlodg;

	}
	

	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public Integer getSlodg() {

		return this.Slodg;

	}
	

	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public Integer getRepNo() {

		return this.repNo;

	}
	

	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public Integer getPlotNo() {

		return this.plotNo;

	}
	

	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public Integer getColumn() {

		return this.column;

	}
	

	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public Integer getRow() {

		return this.row;

	}
	
	

	public static class PlantBuilder {
		/* Use builder pattern so that we can vary types of plants which have the similar data set,
		 * also it is safer than java beans at multi-thread environment.
		 * Use static inner class for better access
		 */
		
		//private static Integer count = 0; // count is used to calculate how many functions are called on the object, so we dont need to pass real numbers.
		private Integer entryNo,DTA,DTS,GW,earHvst,Rlodg,Slodg,repNo,plotNo,column,row;
		private String gid,designation,plantingDate,entryType;
		private Float EH, PH,MOI;
		
		/**
		 * 
		 * @param plantingDate
		 */
		public PlantBuilder setGid(final String gid) {
			this.gid = gid;
			return this;
		}
		
		/**
		 * 
		 * @param plantingDate
		 */
		public PlantBuilder setPlantingDate(final String plantingDate) {
			this.plantingDate = plantingDate;
			return this;
		}

		
		/**
		 * 
		 * @param entryType
		 */
		public PlantBuilder setEntryType(final String entryType) {
			this.entryType = entryType;
			return this;
		}
		
		/**
		 * 
		 * @param designation
		 */
		public PlantBuilder setDesignation(final String designation) {
			this.designation = designation;
			return this;
		}
		
		/**
		 * 
		 * @param entryNo
		 */
		public PlantBuilder setEntryNo(final Integer entryNo) {
			this.entryNo = entryNo;
			return this;
		}
		
		/**
		 * 
		 * @param EH
		 */
		public PlantBuilder setEH(final Float EH) {
			this.EH = EH;
			return this;
		}
		
		
		/**
		 * 
		 * @param PH
		 */
		public PlantBuilder setPH(final Float PH) {
			this.PH = PH;
			return this;
		}
		
		/**
		 * 
		 * @param DTA
		 */
		public PlantBuilder setDTA(final Integer DTA) {
			this.DTA = DTA;
			return this;
		}
		
		/**
		 * 
		 * @param DTS
		 */
		public PlantBuilder setDTS(final Integer DTS) {
			this.DTS = DTS;
			return this;
		}
		
		
		/**
		 * 
		 * @param MOI
		 */
		public PlantBuilder setMOI(final Float MOI) {
			this.MOI = MOI;
			return this;
		}
		
		/**
		 * 
		 * @param GW
		 */
		public PlantBuilder setGW(final Integer GW) {
			this.GW = GW;
			return this;
		}
		
		
		/**
		 * 
		 * @param earHvst
		 */
		public PlantBuilder setEarHvst(final Integer earHvst) {
			this.earHvst = earHvst;
			return this;
		}
		
		/**
		 * 
		 * @param Rlodg
		 */
		public PlantBuilder setRlodg(final Integer Rlodg ) {
			this.Rlodg = Rlodg;
			return this;
		}
		
		/**
		 * 
		 * @param Slog
		 */
		public PlantBuilder setSlodg(final Integer Slog) {
			this.Slodg = Slodg;
			return this;
		}
		
		/**
		 * 
		 * @param repNo
		 */
		public PlantBuilder setRepNo(final Integer repNo) {
			this.repNo = repNo;
			return this;
		}
		
		/**
		 * 
		 * @param plotNo
		 */
		public PlantBuilder setPlotNo(final Integer plotNo) {
			this.plotNo = plotNo;
			return this;
		}
		
		/**
		 * 
		 * @param column
		 */
		public PlantBuilder setColumn(final Integer column) {
			this.column = column;
			return this;
		}
		
		/**
		 * 
		 * @param row
		 */
		public PlantBuilder setRow(final Integer row) {
			this.row = row;
			return this;
		}
		
		
//		public PlantBuilder addCount() {
//				count += 1;
//				return this;
//		}
		
		
//		public static Integer getCount() {
//			return count;
//		}
//		
//		public static void resetCount() {
//			count = 0;
//		}
		
		public Plant build() {
			return new Plant(this);
		}
		
	}

	
	
}
