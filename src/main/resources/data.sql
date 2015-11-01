
INSERT INTO  `users` (`id`, `username`, `passwd`, `permissions`, `uuid`) VALUES
( 0,'q', 'q', 'USER', '2347'),
( 1,'robbert', 'robbert', 'USER,ADMIN', '2345'),
( 2,'john', 'pw', 'USER', '2346');

INSERT INTO `contacts` ( `id`, `user_id`, `name`, `email`, `UUID`) VALUES
( 0,1, 'john', 'john@gmail.com', '1234'),
( 1,1, 'cindy', 'cindy@gmail.com', '1235'),
( 2,0, 'peter', 'peter@gmail.com', '1236'),
( 3,2, 'ray', 'ray@gmail.com', '1237'),
( 4,2, 'jack', 'jack@gmail.com', '1238'),
( 5,2, 'sil', 'sil@gmail.com', '1239');



