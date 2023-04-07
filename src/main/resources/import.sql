INSERT INTO pizzas (name, description, price) VALUES('Margherita', 'Una pizza classica con salsa di pomodoro, mozzarella fresca, basilico e olio di oliva extravergine', 8.00);
INSERT INTO pizzas (name, description, price) VALUES('Quattro Formaggi', 'Una pizza con una combinazione di quattro formaggi diversi come mozzarella, gorgonzola, parmigiano e taleggio', 11.00);
INSERT INTO pizzas (name, description, price) VALUES('Prosciutto e Funghi', 'Una pizza con salsa di pomodoro, mozzarella fresca, prosciutto cotto e funghi champignon', 10.00);
INSERT INTO pizzas (name, description, price) VALUES('Vegetariana', 'Una pizza senza carne, con salsa di pomodoro, mozzarella fresca, pomodori freschi, peperoni, cipolle rosse, olive nere e origano', 9.00);
INSERT INTO pizzas (name, description, price) VALUES('Salmone Piccante', 'Una pizza con salsa di pomodoro, mozzarella fresca e salame piccante', 10.00);

INSERT INTO ingredients (ingredient) VALUES('cipolla');
INSERT INTO ingredients (ingredient) VALUES('prosciutto');
INSERT INTO ingredients (ingredient) VALUES('wrustel');
INSERT INTO ingredients (ingredient) VALUES('mozzarella');
INSERT INTO ingredients (ingredient) VALUES('olio');
INSERT INTO ingredients (ingredient) VALUES('origano');
INSERT INTO ingredients (ingredient) VALUES('olive');
INSERT INTO ingredients (ingredient) VALUES('sugo');
INSERT INTO ingredients (ingredient) VALUES('tonno');
INSERT INTO ingredients (ingredient) VALUES('melanzane');

INSERT INTO users (email, password, username) VALUES('admin@gmail.com', '{noop}admin', 'admin');
INSERT INTO roles (name) VALUES('ADMIN');
INSERT INTO users_roles (user_id, roles_id) VALUES(1,1);

INSERT INTO users (email, password, username) VALUES('user@gmail.com', '{noop}user', 'user');
INSERT INTO roles (name) VALUES('USER');
INSERT INTO users_roles (user_id, roles_id) VALUES(2,2);

