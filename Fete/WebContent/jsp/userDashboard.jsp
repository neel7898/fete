<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <%= session.getAttribute("sessionUser") %> --%>
<div style="margin-top: 50px;">
	<div class="col-sm-2 side-nav" style="height: 100vh; padding: 0px;" >

		<a href="#userDashboard"><div class="dashboard-menu">
			<p style="font-size: 16px;"><i class="fa fa-home" aria-hidden="true"></i> &nbsp Dashboard</p>
		</div></a>
		<a href="#accountDetails"><div class="side-menu">
			<p style="font-size: 16px;"><i class="fa fa-user" aria-hidden="true"></i> &nbsp Manage Account</p>
		</div></a>
		<a href="#myBookings"><div class="side-menu">
			<p style="font-size: 16px;"><i class="fa fa-calendar" aria-hidden="true"></i> &nbsp My Bookings</p>
		</div></a>
				<a href="#myHall"><div class="side-menu">
			<p style="font-size: 16px;"><i class="fa fa-building" aria-hidden="true"></i> &nbsp Private Hall</p>
		</div></a>
		<a href="#myMenu"><div class="side-menu">
			<p style="font-size: 16px;"><i class="fa fa-cutlery" aria-hidden="true"></i> &nbsp Your Menu</p>
		</div></a>
		<a href="#myDjDetails"><div class="side-menu">
			<p style="font-size: 16px;"><i class="fa fa-music" aria-hidden="true"></i> &nbsp DJ Details</p>
		</div></a>
		<a href="#myDecoration"><div class="side-menu">
			<p style="font-size: 16px;"><i class="fa fa-diamond" aria-hidden="true"></i> &nbsp Decoration</p>
		</div></a>
		<a href="#myPackages"><div class="side-menu">
			<p style="font-size: 16px;"><i class="fa fa-dropbox" aria-hidden="true"></i> &nbsp Party Packages</p>
		</div></a>
		<a href="#myCoupon"><div class="side-menu">
			<p style="font-size: 16px;"><i class="fa fa-gift" aria-hidden="true"></i> &nbsp Discount/Coupons</p>
		</div></a>
		<a href="#myTransport"><div class="side-menu">
			<p style="font-size: 16px;"><i class="fa fa-taxi" aria-hidden="true"></i> &nbsp Transportation</p>
		</div></a>
		<a href="#otherServices"><div class="side-menu">
			<p style="font-size: 16px;"><i class="fa fa-bars" aria-hidden="true"></i> &nbsp Other Services</p>
		</div></a>
		<a href="#address"><div class="side-menu">
			<p style="font-size: 16px;"><i class="fa fa-map-signs" aria-hidden="true"></i> &nbsp Location</p>
		</div></a>			
	
		
	</div>
	<div class="col-sm-10" style="height:100vh;background-color: #ffffff;">
		<div style="padding: 10px;">
			<h2>DashBoard</h2><hr>
			<div class="text-center">
			<h3>New Bookings</h3>
			<div class="tabel-responsive"><table class="table table-hover">
    <thead>
   
      <tr style="background-color: orange;">
      	<th style="text-align: center;">Booking ID</th>
        <th style="text-align: center;">Customer Name</th>
        <th style="text-align: center;">Date</th>
        <th style="text-align: center;">Time</th>
        <th style="text-align: center;">Package</th>
      </tr>
    </thead>
    <tbody>
      <tr class="active">
        <td colspan="5">No New Bookings</td>
      </tr>
     </tbody>
  </table></div>
  <h3 style="margin-top: 20px;">Quick Menu</h3>
			</div>
			
			<div class="row">
				<a href="#myMenu">
				<div class="col-sm-4 dashboard-card">
					<div style="background-image: url('images/menu.jpg');">
						<div class="dashboard-card-content overlay"><h3>Add Menu Items</h3></div>
					</div>
				</div>
				</a>
				<a href="#myHall">
				<div class="col-sm-4 dashboard-card">
					
					<div style="background-image: url('images/partyHall.jpg');">
						<div class="dashboard-card-content overlay"><h3>Add Party Hall</h3></div>
					</div>
				</div>
				</a>
				<a href="#myDjDetails">
				<div class="col-sm-4 dashboard-card">
					
					<div style="background-image: url('images/dj.jpg');">
						<div class="dashboard-card-content overlay"><h3>Add DJ details</h3></div>
					</div>
				</div>
				</a>
				<a>
			</div>
			
			<div class="row" style="margin-top: 15px;">
			
				<a href="#myPackages">
				<div class="col-sm-4 dashboard-card">
					<div style="background-image: url('images/hotdeal.png');">
						<div class="dashboard-card-content overlay" style="	background-color: rgba(0, 0, 0, 0.9);"><h3>Party Packages</h3></div>
					</div>
				</div>
				</a>
				<a href="#myCoupon">
				<div class="col-sm-4 dashboard-card">
					
					<div style="background-image: url('images/specialoffer.png');">
						<div class="dashboard-card-content overlay" style="	background-color: rgba(0, 0, 0, 0.9);"><h3>Discount / Coupons</h3></div>
					</div>
					
				</div>
				</a>
				<a href="#myTransport">
				<div class="col-sm-4 dashboard-card">
					
					<div style="background-image: url('images/taxi.jpg');">
						<div class="dashboard-card-content overlay"><h3>Add Transportation</h3></div>
					</div>
					
				</div>
				</a>
			</div>
			
			
		</div>
	</div>
</div>
