CREATE TABLE urls
(
    url           TEXT PRIMARY KEY,
    periodMinutes INTEGER                  NOT NULL DEFAULT 1,
    startAt       TIMESTAMP WITH TIME ZONE NOT NULL
--     lastCheckedAt TIMESTAMP NOT NULL
);

CREATE TABLE urls_checks
(
    url       TEXT REFERENCES urls     NOT NULL,
    checkedAt TIMESTAMP WITH TIME ZONE NOT NULL,
    result    BOOLEAN                  NOT NULL,
    PRIMARY KEY (url, checkedAt)
);