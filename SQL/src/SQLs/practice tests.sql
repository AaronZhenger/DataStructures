CREATE TABLE IF NOT EXISTS team(team_id INT NOT NULL PRIMARY KEY, team_name varchar(10));
CREATE TABLE IF NOT EXISTS player(player_id INT NOT NULL PRIMARY KEY, team_id INT NOT NULL, player_name varchar(10));

-- INSERT INTO team(team_id, team_name) VALUES
-- (1, 'Red'),
-- (2, 'Blue'),
-- (3, 'Green'),
-- (4, 'Gold');

-- INSERT INTO player(player_id, team_id, player_name) VALUES
-- (1, 1, 'Amy'),
-- (2, 1, 'Ben'),
-- (3, 2, 'Cam'),
-- (4, 2, 'Dia'),
-- (5, 2, 'Eli');

SELECT *
FROM team
LEFT JOIN player
ON team.team_id = player.team_id;