package cn.blank.pojo;

public class Novel {
    @Override
	public String toString() {
		return "Novel [id=" + id + ", source=" + source + ", bookname=" + bookname + ", bookurl=" + bookurl
				+ ", lastchapterurl=" + lastchapterurl + ", author=" + author + ", type=" + type + ", status=" + status
				+ ", lastchapter=" + lastchapter + ", size=" + size + ", lastupdate=" + lastupdate + "]";
	}

	private Integer id;
    private String source;
    
    

    public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	private String bookname;

    private String bookurl;

    private String lastchapterurl;

    private String author;

    private String type;

    private Integer status;

    private String lastchapter;

    private String size;

    private String lastupdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public String getBookurl() {
        return bookurl;
    }

    public void setBookurl(String bookurl) {
        this.bookurl = bookurl == null ? null : bookurl.trim();
    }

    public String getLastchapterurl() {
        return lastchapterurl;
    }

    public void setLastchapterurl(String lastchapterurl) {
        this.lastchapterurl = lastchapterurl == null ? null : lastchapterurl.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLastchapter() {
        return lastchapter;
    }

    public void setLastchapter(String lastchapter) {
        this.lastchapter = lastchapter == null ? null : lastchapter.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public String getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(String lastupdate) {
        this.lastupdate = lastupdate == null ? null : lastupdate.trim();
    }
}