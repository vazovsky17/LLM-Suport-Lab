CREATE TABLE tickets (
    id UUID PRIMARY KEY,
    text TEXT NOT NULL,
    status VARCHAR(32) NOT NULL,

    category VARCHAR(32),
    priority VARCHAR(32),
    summary TEXT,
    suggested_reply TEXT,

    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL
);