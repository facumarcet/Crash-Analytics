from django.urls import path
from .views import runScrapper

urlpatterns = [
    path('scrapper', runScrapper, name='home')
]