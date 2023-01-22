package com.glearning.tta.model;

   import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

	@Entity
	public class Ticket {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		@Column(name="ticketTitle")
		private String ticketTitle;
		@Column(name="shortDec")
		private String shortDec;
		@Column(name="content")
		private String content;
		@Temporal(TemporalType.DATE)
		@Column(name="date")
		private Date date=new Date();
		
		public Ticket() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Ticket(int id, String ticketTitle, String shortDec, String content, Date date) {
			super();
			this.id = id;
			this.ticketTitle = ticketTitle;
			this.shortDec = shortDec;
			this.content = content;
			this.date = date;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTicketTitle() {
			return ticketTitle;
		}

		public void setTicketTitle(String ticketTitle) {
			this.ticketTitle = ticketTitle;
		}

		public String getShortDec() {
			return shortDec;
		}

		public void setShortDec(String shortDec) {
			this.shortDec = shortDec;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		@Override
		public String toString() {
			return "Ticket [id=" + id + ", ticketTitle=" + ticketTitle + ", shortDec=" + shortDec + ", content=" + content
					+ ", date=" + date + "]";
		}
	}

