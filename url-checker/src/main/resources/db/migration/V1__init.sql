CREATE TABLE urls
(
    url           TEXT PRIMARY KEY,
    periodMinutes INTEGER                  NOT NULL DEFAULT 1,
    nextCheckAt   TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
    createdAt     TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now()
);

CREATE TABLE urls_checks
(
    url       TEXT REFERENCES urls     NOT NULL,
    createdAt TIMESTAMP WITH TIME ZONE NOT NULL,
    result    BOOLEAN                  NOT NULL,
    PRIMARY KEY (url, createdAt)
);