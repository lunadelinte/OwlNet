INSERT INTO applicationuser (email, nickname, password)
VALUES
('jadebutterfly@email.com', 'butterflyJade', 'butterfly'),
('mysticdreamer@email.com', 'dreamerMystic', 'mystic'),
('zenmaster@email.com', 'masterZen', 'master'),
('serenadesoul@email.com', 'soulSerena', 'serena'),
('rainbowharmony@email.com', 'harmonyRainbow', 'harmony');

INSERT INTO workspace (name)
VALUES
('Alpha'),
('Bravo');

INSERT INTO booking (bookingDate, applicationuser_id, workspace_id )
VALUES
('2023-10-2', 1, 1);

-- INSERT INTO event (eventDate)
-- VALUES
-- ('2023-10-3');

-- INSERT INTO event_applicationusers (applicationuser_id, event_id)
-- VALUES
-- (1,1);
