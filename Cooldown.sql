CREATE TABLE user (
                      u_id INT AUTO_INCREMENT PRIMARY KEY,
                      userid VARCHAR(18) NOT NULL UNIQUE,
                      password VARCHAR(18) NOT NULL,
                      email VARCHAR(60) NOT NULL UNIQUE,
                      nickname VARCHAR(20) NOT NULL UNIQUE,
                      phone VARCHAR(15) NOT NULL,
                      zipcode VARCHAR(10) NOT NULL,
                      address1 VARCHAR(60) NOT NULL,
                      address2 VARCHAR(60),
                      birth DATE,
                      username VARCHAR(10) NOT NULL,
                      regdate DATETIME default current_timestamp,
                      role ENUM('Admin', 'User') NOT NULL DEFAULT 'User'
);

CREATE TABLE item (
                      item_id INT AUTO_INCREMENT PRIMARY KEY,
                      category VARCHAR(20)  NOT NULL,
                      itemname VARCHAR(50)  NOT NULL,
                      price int(10)  NOT NULL,
                      img VARCHAR(100),
                      likes INT,
                      info VARCHAR(200),
                      stock INT
);

CREATE TABLE orders (
                        order_id INT  AUTO_INCREMENT  PRIMARY KEY,
                        u_id INT NOT NULL,
                        item_id INT NOT NULL,
                        username VARCHAR(10) NOT NULL,
                        phone VARCHAR(15) NOT NULL,
                        email VARCHAR(60) NOT NULL,
                        zipcode VARCHAR(10) NOT NULL,
                        address1 VARCHAR(60) NOT NULL,
                        address2 VARCHAR(60),
                        account_number int(10) NOT NULL,
                        payment_amount int(10) NOT NULL,
                        FOREIGN KEY (u_id) REFERENCES user(u_id),
                        FOREIGN KEY (item_id) REFERENCES item(item_id)
);

CREATE TABLE detailed_orders (
                                 d_orderid INT  AUTO_INCREMENT  PRIMARY KEY,
                                 order_id INT,
                                 item_id INT,
                                 quantity INT(5)  NOT NULL,
                                 totalcost int(10)  NOT NULL,
                                 FOREIGN KEY (order_id) REFERENCES orders(order_id),
                                 FOREIGN KEY (item_id) REFERENCES item(item_id)
);

CREATE TABLE shipping (
                          shipping_id INT AUTO_INCREMENT  PRIMARY KEY,
                          order_id INT,
                          zipcode VARCHAR(10)  NOT NULL,
                          address1 VARCHAR(60)  NOT NULL,
                          address2 VARCHAR(60),
                          FOREIGN KEY (order_id) REFERENCES orders(order_id)
);

CREATE TABLE payments (
                          payments_id INT PRIMARY KEY AUTO_INCREMENT,
                          order_id INT NOT NULL,
                          d_orderid INT NOT NULL,
                          p_method VARCHAR(20) NOT NULL,
                          p_amount INT(10) NOT NULL,
                          p_status VARCHAR(20) NOT NULL,
                          p_date DATETIME default current_timestamp,
                          bank_name VARCHAR(10) NOT NULL,
                          account_number VARCHAR(10) NOT NULL,
                          depositor_name VARCHAR(10) NOT NULL,
                          cart_transaction_id INT,
                          FOREIGN KEY (order_id) REFERENCES orders(order_id),
                          FOREIGN KEY (d_orderid) REFERENCES detailed_orders(d_orderid)
);

CREATE TABLE contents (
                          contents_id INT PRIMARY KEY AUTO_INCREMENT,
                          title VARCHAR(30) NOT NULL,
                          u_id INT NOT NULL,
                          views INT DEFAULT 0,
                          contents TEXT NOT NULL,
                          img VARCHAR(255),
                          likes INT DEFAULT 0,
                          comment_count INT DEFAULT 0,
                          regdate DATETIME default current_timestamp,
                          FOREIGN KEY (u_id) REFERENCES user(u_id)
);
CREATE TABLE board (
                       board_id INT AUTO_INCREMENT PRIMARY KEY,
                       category VARCHAR(7) NOT NULL,
                       title VARCHAR(30) NOT NULL,
                       u_id INT NOT NULL,
                       views INT DEFAULT 0,
                       contents TEXT NOT NULL,
                       img VARCHAR(255),
                       likes INT DEFAULT 0,
                       comment_count INT DEFAULT 0,
                       regdate DATETIME DEFAULT CURRENT_TIMESTAMP,
                       FOREIGN KEY (u_id) REFERENCES user(u_id)
);

CREATE TABLE qna (
                     qna_id INT AUTO_INCREMENT PRIMARY KEY,
                     u_id INT NOT NULL,
                     title VARCHAR(30) NOT NULL,
                     contents TEXT NOT NULL,
                     regdate DATETIME DEFAULT CURRENT_TIMESTAMP,
                     answer TEXT,
                     FOREIGN KEY (u_id) REFERENCES user(u_id)
);

CREATE TABLE itemqna (
                         itemqna_id INT AUTO_INCREMENT PRIMARY KEY,
                         u_id INT NOT NULL,
                         item_id INT NOT NULL,
                         title VARCHAR(30) NOT NULL,
                         contents TEXT NOT NULL,
                         regdate DATETIME DEFAULT CURRENT_TIMESTAMP,
                         secret INT DEFAULT 0,
                         answer TEXT,
                         FOREIGN KEY (u_id) REFERENCES user(u_id),
                         FOREIGN KEY (item_id) REFERENCES item(item_id)
);

CREATE TABLE c_reply (
                         c_reply_id INT AUTO_INCREMENT PRIMARY KEY,
                         u_id INT NOT NULL,
                         contents_id INT NOT NULL,
                         regdate DATETIME DEFAULT CURRENT_TIMESTAMP,
                         contents TEXT NOT NULL,
                         report INT DEFAULT 0,
                         FOREIGN KEY (u_id) REFERENCES user(u_id),
                         FOREIGN KEY (contents_id) REFERENCES contents(contents_id)
);

CREATE TABLE reply (
                       reply_id INT AUTO_INCREMENT PRIMARY KEY,
                       u_id INT NOT NULL,
                       board_id INT NOT NULL,
                       regdate DATETIME DEFAULT CURRENT_TIMESTAMP,
                       contents TEXT NOT NULL,
                       report INT DEFAULT 0,
                       FOREIGN KEY (u_id) REFERENCES user(u_id),
                       FOREIGN KEY (board_id) REFERENCES board(board_id)
);

CREATE TABLE cart (
                      cart_id INT AUTO_INCREMENT PRIMARY KEY,
                      u_id INT NOT NULL,
                      item_id INT NOT NULL,
                      count INT DEFAULT 0,
                      FOREIGN KEY (u_id) REFERENCES user(u_id),
                      FOREIGN KEY (item_id) REFERENCES item(item_id)
);

CREATE TABLE alert (
                       alert_id INT AUTO_INCREMENT PRIMARY KEY,
                       u_id INT NOT NULL,
                       alert_contents TEXT,
                       FOREIGN KEY (u_id) REFERENCES user(u_id)
);





