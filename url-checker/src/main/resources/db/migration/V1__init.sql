CREATE TABLE urls
(
    url           TEXT PRIMARY KEY,
    periodMinutes INTEGER                  NOT NULL DEFAULT 1,
    startAt       TIMESTAMP WITH TIME ZONE NOT NULL,
    createdAt     TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now()
--     lastCheckedAt TIMESTAMP NOT NULL
);

CREATE TABLE urls_checks
(
    url       TEXT REFERENCES urls     NOT NULL,
    createdAt TIMESTAMP WITH TIME ZONE NOT NULL,
    result    BOOLEAN                  NOT NULL,
    PRIMARY KEY (url, createdAt)
);