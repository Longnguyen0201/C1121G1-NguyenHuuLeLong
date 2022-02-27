use ss2_quan_ly_ban_hang;

insert into customer values
(1,'Minh Quan', 10),
(2,'Ngoc Oanh', 20), 
(3,'Hong Ha', 50);
select * from customer;

insert into `order` values
(1,1,'2006-03-21',null),
(2,2,'2006-03-23',null),
(3,1,'2006-03-16',null);
select*from `order`;

insert into product values 
(1,'May Giat',3),
(2,'Tu Lanh',5),
(3,'Dieu Hoa',7),
(4,'Quat',1),
(5,'Bep Dien',2);
select * from product;

insert into order_detail values
(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);
select * from order_detail;
-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select oID , oDate, oTotalPrice from `order`;
-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select customer.cID, customer.cName, product.pName from customer
join `order` on customer.cID = `order`.cID 
join order_detail on `order`.oID = order_detail.oID
join product on order_detail.pID = product.pID;
-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào.
select customer.cName from customer
where cID not in  (
select cID from `order`);
-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
select `order`.oID, date_format(`order`.oDate, '%d %M %Y')as oDate, sum(order_detail.odQty*product.pPrice) as oTotalPrice from `order`
join  order_detail on `order`.oID = order_detail.oID
join product on order_detail.pID = product.pID
group by oID
order by oDate;