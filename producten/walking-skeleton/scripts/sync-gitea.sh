#!/bin/sh
KEYCLOAK_URL="http://localhost:8081/realms/BDrealm/protocol/openid-connect/token"
CLIENT_ID="springboot-client"
CLIENT_SECRET="sXcU4LFYYv4eX4W03MV4oWYwo7B6McQ7"
USERNAME="bob"
PASSWORD="bobpass"

response=$(curl -s -X POST "$KEYCLOAK_URL" \
  -H "Content-Type: application/x-www-form-urlencoded" \
  -d "grant_type=password" \
  -d "client_id=$CLIENT_ID" \
  -d "client_secret=$CLIENT_SECRET" \
  -d "username=$USERNAME" \
  -d "password=$PASSWORD")

# Access token uit JSON response halen :D
access_token=$(echo "$response" | grep -o '"access_token":"[^"]*"' | cut -d':' -f2- | tr -d '"')

if [[ -z "$access_token" ]]; then
  echo "Could not get access token from Keycloak"
  echo "$response"
  exit 1
fi

curl -v -X POST http://localhost:8080/sync-gitea \
  -H "Authorization: Bearer $access_token" \
  -H "Content-Type: application/json"
