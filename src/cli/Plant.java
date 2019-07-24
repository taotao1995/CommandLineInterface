package cli;

public class Plant {
	// Use int instead of integer for less overhead.
	private int entryNo,DTA,DTS,GW,earHvst,Rlodg,Slodg,repNo,plotNo,column,row;
	private String gid,designation,plantingDate,entryType;
	private float EH, PH,MOI;

	
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
	public String getGid(String gid) {
		if(this.gid != null)
			return this.gid;
		else return null;
	}
	
	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public String getPlantingDate(String gid) {
		if(this.gid == gid)
			return this.plantingDate;
		else return null;
	}
	

	/**
	 * 
	 * @param gid
	 * @return
	 */
	public String getEntryType(String gid) {
		if(this.gid == gid)
			return this.entryType;
		else return null;
	}
	

	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public String getDesignation(String gid) {
		if(this.gid == gid)
			return this.designation;
		else return null;
	}
	
	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public int getEntryNo(String gid) {
		if(this.gid == gid)
			return this.entryNo;
		else return -1;
	}
	

	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public float getEH(String gid) {
		if(this.gid == gid)
			return this.EH;
		else return -1;
	}
	
	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public float getPH(String gid) {
		if(this.gid == gid)
			return this.PH;
		else return -1;
	}
	

	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public int getDTA(String gid) {
		if(this.gid == gid)
			return this.DTA;
		else return -1;
	}
	

	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public int getDTS(String gid) {
		if(this.gid == gid)
			return this.DTS;
		else return -1;
	}
	

	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public float getMOI(String gid) {
		if(this.gid == gid)
			return this.MOI;
		else return -1;
	}
	

	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public int getGW(String gid) {
		if(this.gid == gid)
			return this.GW;
		else return -1;
	}
	

	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public int getEarHvst(String gid) {
		if(this.gid == gid)
			return this.earHvst;
		else return -1;
	}
	

	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public int getRlodg(String gid) {
		if(this.gid == gid)
			return this.Rlodg;
		else return -1;
	}
	

	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public int getSlodg(String gid) {
		if(this.gid == gid)
			return this.Slodg;
		else return -1;
	}
	

	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public int getRepNo(String gid) {
		if(this.gid == gid)
			return this.repNo;
		else return -1;
	}
	

	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public int getPlotNo(String gid) {
		if(this.gid == gid)
			return this.plotNo;
		else return -1;
	}
	

	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public int getColumn(String gid) {
		if(this.gid == gid)
			return this.column;
		else return -1;
	}
	

	
	/**
	 * 
	 * @param gid
	 * @return
	 */
	public int getRow(String gid) {
		if(this.gid == gid)
			return this.row;
		else return -1;
	}
	
	

	public static class PlantBuilder {
		/* Use builder pattern so that we can vary types of plants which have the similar data set,
		 * also it is safer than java beans at multi-thread environment.
		 * Use static inner class for better access
		 */

		private int entryNo,DTA,DTS,GW,earHvst,Rlodg,Slodg,repNo,plotNo,column,row;
		private String gid,designation,plantingDate,entryType;
		private float EH, PH,MOI;
		
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
		public PlantBuilder setEntryNo(final int entryNo) {
			this.entryNo = entryNo;
			return this;
		}
		
		/**
		 * 
		 * @param EH
		 */
		public PlantBuilder setEH(final float EH) {
			this.EH = EH;
			return this;
		}
		
		
		/**
		 * 
		 * @param PH
		 */
		public PlantBuilder setPH(final float PH) {
			this.PH = PH;
			return this;
		}
		
		/**
		 * 
		 * @param DTA
		 */
		public PlantBuilder setDTA(final int DTA) {
			this.DTA = DTA;
			return this;
		}
		
		/**
		 * 
		 * @param DTS
		 */
		public PlantBuilder setDTS(final int DTS) {
			this.DTS = DTS;
			return this;
		}
		
		
		/**
		 * 
		 * @param MOI
		 */
		public PlantBuilder setMOI(final float MOI) {
			this.MOI = MOI;
			return this;
		}
		
		/**
		 * 
		 * @param GW
		 */
		public PlantBuilder setGW(final int GW) {
			this.GW = GW;
			return this;
		}
		
		
		/**
		 * 
		 * @param earHvst
		 */
		public PlantBuilder setEarHvst(final int earHvst) {
			this.earHvst = earHvst;
			return this;
		}
		
		/**
		 * 
		 * @param Rlodg
		 */
		public PlantBuilder setRlodg(final int Rlodg ) {
			this.Rlodg = Rlodg;
			return this;
		}
		
		/**
		 * 
		 * @param Slog
		 */
		public PlantBuilder setSlodg(final int Slog) {
			this.Slodg = Slodg;
			return this;
		}
		
		/**
		 * 
		 * @param repNo
		 */
		public PlantBuilder setRepNo(final int repNo) {
			this.repNo = repNo;
			return this;
		}
		
		/**
		 * 
		 * @param plotNo
		 */
		public PlantBuilder setPlotNo(final int plotNo) {
			this.plotNo = plotNo;
			return this;
		}
		
		/**
		 * 
		 * @param column
		 */
		public PlantBuilder setColumn(final int column) {
			this.column = column;
			return this;
		}
		
		/**
		 * 
		 * @param row
		 */
		public PlantBuilder setRow(final int row) {
			this.row = row;
			return this;
		}
		
		
		public Plant build() {
			return new Plant(this);
		}
		
	}

	
	
}
