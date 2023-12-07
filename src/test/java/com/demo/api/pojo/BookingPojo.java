package com.demo.api.pojo;

/**
 * @description class represents booking details, encapsulating data for api requests.
 */
public class BookingPojo {
	private int bookingid;

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	@Override
	public String toString() {
		return "BookingPojo{bookingId=" + bookingid + "}";
	}

}
