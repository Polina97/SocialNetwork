INSERT INTO social_network.user_role
	(name)
VALUES
	('Admin'),
    ('User');

INSERT INTO social_network.user 
	(login, password, blocked, user_role_id, email) 
VALUES 
	('god', 'god1', 0, 1, 'god@test.com'),
	('adam', 'adam1', 0, 2, 'adam@test.com'),
    ('eva', 'eva1', 0, 2, 'eva@test.com');
    
INSERT INTO social_network.profile
	(first_name, last_name, birth_date, gender, address, martial_status, user_id)
values
	('Ferdinand', 'Pavlovich', '1990-01-14', 'MALE', 'DOMBROVKA BABY', 'MARRIED', 1),
    ('Vasja', 'Andreev', '1985-06-23', 'MALE', 'BLK', 'NONE', 2),
    ('Olga', 'Vasilevna', '1988-10-16', 'FEMALE', 'Kurchatova', 'MARRIED', 3);
    
INSERT INTO social_network.profile_friend
	(profile_id, friend_id, status)
VALUES
	(1, 2, 'FRIEND'),
    (1, 3, 'SUBSCRIBER');
    
INSERT INTO social_network.group
	(owner_id, name, access, description)
VALUES
	(1, 'test group', 1, 'test description of the group');
    
INSERT INTO social_network.profile_group
	(group_id, profile_id, confirmed)
VALUES
	(1, 2, 1);
    
INSERT INTO social_network.profile_wall_message
	(profile_id, owner_id, message, date)
VALUES
	(2, 2, 'test profile wall message', NOW());
    
INSERT INTO social_network.group_wall_message
	(group_id, owner_id, message, date)
VALUES
    (1, 2, 'test group wall message', NOW());

INSERT INTO social_network.personal_message
	(message, readed, date, edit_end_date, owner_id)
VALUES
	('Hi Olga', 1, '2018-03-12 10:10:10', '2018-03-12 10:20:10', 1),
    ('Hi Ferdi', 0, '2018-03-12 12:15:00', '2018-03-12 12:25:00', 3);
    
INSERT INTO social_network.personal_message_profile
	(profile_id, personal_message_id)
VALUES 
	(3, 1),
    (1, 2);
    
INSERT INTO social_network.profile_photo
	(url, current, profile_id)
VALUES
	('assets/images/static-profile-photo.jpg', 1, 2),
    ('assets/images/empty.jpg', 0, 2);