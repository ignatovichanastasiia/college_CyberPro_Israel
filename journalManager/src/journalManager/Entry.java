package journalManager;

import java.io.Serializable;

class Entry implements Serializable {
	private String entryName;
	private String content;
	

	public Entry(String entryName, String content) {
		this.entryName = entryName;
		this.content = content;
	}


	public String getEntryName() {
		return entryName;
	}

	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String toString() {
		return "Entry [entryName=" + entryName + ", content=" + content + "]";
	}	
	
}
