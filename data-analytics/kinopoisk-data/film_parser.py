import requests
import csv
import time

class KinopoiskAPI:
    def __init__(self, api_key):
        self.api_key = api_key

    def make_api_request(self, user_id, page):
        url = f'https://kinopoiskapiunofficial.tech/api/v1/kp_users/{user_id}/votes?page={page}'
        headers = {
            'accept': 'application/json',
            'X-API-KEY': self.api_key
        }

        response = requests.get(url, headers=headers)
        return response.json()

    def retrieve_user_data(self, user_id):
        page = 1
        total_pages = 1  # Initialize with 1 to enter the loop

        while page <= total_pages:
            response_data = self.make_api_request(user_id, page)

            if 'items' in response_data:
                items = response_data['items']
                self.save_to_csv(items, 'user_data.csv')

                total_pages = response_data.get('totalPages', 1)
                page += 1

                # Add a delay to stay within rate limits
                time.sleep(1)  # Adjust the delay as needed

            else:
                print(f"Error in API response on page {page}: {response_data}")
                break

    @staticmethod
    def save_to_csv(data, csv_filename):
        with open(csv_filename, 'a', newline='', encoding='utf-8') as csvfile:
            fieldnames = ["kinopoiskId", "imdbId", "nameRu", "nameEn", "nameOriginal", "countries", "genres",
                          "ratingKinopoisk", "ratingImdb", "year", "type", "posterUrl",
                          "posterUrlPreview", "userRating"]

            writer = csv.DictWriter(csvfile, fieldnames=fieldnames)

            if csvfile.tell() == 0:  # Write header only if the file is empty
                writer.writeheader()

            writer.writerows(data)

if __name__ == "__main__":
    api_key = 'YOUR_API_KEY'
    user_id = 'USER_ID'

    kinopoisk_api = KinopoiskAPI(api_key)
    kinopoisk_api.retrieve_user_data(user_id)
