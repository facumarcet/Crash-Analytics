from django.http import HttpResponse, HttpResponseServerError
from urllib.request import Request, urlopen
import json
import requests

def byteToJson(byte):
    decodedWebpage = byte.decode('utf8').replace("'", '"')
    decodedWebpage = decodedWebpage.replace("'", '"')
    #print(decodedWebpage)
    data = json.loads(decodedWebpage)
    #s = json.dumps(data, indent=4, sort_keys=True)
    return json.dumps(data)
def getAverage(arr):
    npArr = np.array(arr)
    return np.average(npArr)

#crashPoints = [o['crashPoint'] for o in crashHistoryJson]
#crashAverage = getAverage(crashPoints)
# Send Crash History To Service


#print(test)
#print(activeGameJson['bets'])


def runScrapper(request):
    try:
        activeGameUrl = 'https://api.roobet.com/crash/getActiveGame'
        crashHistoryUrl = 'https://api.roobet.com/crash/recentNumbers'
        dbServiceUrl = 'http://192.168.0.14:8080'
        headers = {'User-Agent': 'Mozilla/5.0'}
        # Active Game Data
        activeGameReq = Request(activeGameUrl, headers=headers)
        activeGameResponse = urlopen(activeGameReq).read()
        activeGameJson = byteToJson(activeGameResponse)
        # Crash History data
        crashHistoryReq = Request(crashHistoryUrl, headers=headers)
        crashHistoryResponse = urlopen(crashHistoryReq).read()
        crashHistoryJson = byteToJson(crashHistoryResponse)
        # Request
        serviceHeaders= {'Content-type':'application/json', 'Accept':'application/json'}
        r = requests.post(dbServiceUrl+'/rocketCrash/create', data=crashHistoryJson, headers=serviceHeaders)
        print("------------------------------")
        print(r.status_code, r.reason)
        print("------------------------------")
        return HttpResponse('Scrapper finished working')
    except:
        return HttpResponseServerError()