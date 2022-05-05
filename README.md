# VanishRobots

**1) ADD SURVIVOR**


endpoint:  http://localhost:8080/addSurvivor

method: POST

Samples:

sample 1

{
    "name":"rana",
    "age":25,
    "gender":"male",
    "lastLocation":"12.23.34,32.34.32",
    "inventories":[{
        "resource":"water"
    }]
    
}

sample 2

{
    "name":"ramu",
    "age":25,
    "gender":"male",
    "lastLocation":"12.23.34,32.34.32",
    "inventories":[{
        "resource":"medical kit"
    }]
    
} 

sample 3

{
    "name":"sinu",
    "age":25,
    "gender":"male",
    "lastLocation":"12.23.34,32.34.32",
    "inventories":[{
        "resource":"food"
    }]
    
} 

sample 4

{
    "name":"sinu",
    "age":25,
    "gender":"male",
    "lastLocation":"12.23.34,32.34.32",
    "inventories":[{
        "resource":"shelter"
    }]
    
} 

Response: 201 if successfully created.


**2) Update Survivor location**


endpoint: http://localhost:8080/updateSurvivorLocation/1?latitudeLongitude={latitudeLongitude}

method: patch

sample: http://localhost:8080/updateSurvivorLocation/1?latitudeLongitude=38.38.39,38.37.83

Response: 200 if successfully updated.


**3) report infected person**


endpoint: http://localhost:8080/reportInfection?reportingSurvivorId={reportingSurvivorId}&infectedSurvivorId={infectedSurvivorId}

method: Get

sample1: http://localhost:8080/reportInfection?reportingSurvivorId=3&infectedSurvivorId=1

sample2: http://localhost:8080/reportInfection?reportingSurvivorId=2&infectedSurvivorId=1

sample3: http://localhost:8080/reportInfection?reportingSurvivorId=1&infectedSurvivorId=1

Report on survivor 1 with three different survivor Id's. Then survivor 1 status will be changed to infected.

Response: 201 if all validations are passed. otherwise 208 if duplicate request.


**4: Get Reports**


endpoint: http://localhost:8080/reports

method: Get

sample: http://localhost:8080/reports

Response:

{
    "percentageOfInfectedSurvivors": 25,
    "percentageOfNonInfectedSurvivors": 75,
    "infectedSurvivors": [
        {
            "id": 1,
            "name": "rana",
            "gender": "male",
            "age": 25,
            "lastLocation": "12.23.34,32.34.32",
            "inventories": [
                {
                    "id": 1,
                    "resource": "water"
                }
            ],
            "infectionReportedCount": 3,
            "infected": true
        }
    ],
    "nonInfectedSurvivors": [
        {
            "id": 2,
            "name": "rana",
            "gender": "male",
            "age": 25,
            "lastLocation": "12.23.34,32.34.32",
            "inventories": [
                {
                    "id": 2,
                    "resource": "water"
                }
            ],
            "infectionReportedCount": 0,
            "infected": false
        },
        {
            "id": 3,
            "name": "rana",
            "gender": "male",
            "age": 25,
            "lastLocation": "12.23.34,32.34.32",
            "inventories": [
                {
                    "id": 3,
                    "resource": "water"
                }
            ],
            "infectionReportedCount": 0,
            "infected": false
        },
        {
            "id": 4,
            "name": "rana",
            "gender": "male",
            "age": 25,
            "lastLocation": "12.23.34,32.34.32",
            "inventories": [
                {
                    "id": 4,
                    "resource": "water"
                }
            ],
            "infectionReportedCount": 0,
            "infected": false
        }
    ],
    "robots": [
        {
            "model": "0V9VW",
            "serialNumber": "9TQ2CAINYFHTOUD",
            "manufacturedDate": "2022-05-12T17:17:29.7631869+00:00",
            "category": "Land"
        },
        {
            "model": "1F880",
            "serialNumber": "05CJDDJFMLJKWGF",
            "manufacturedDate": "2022-05-07T17:17:29.7631816+00:00",
            "category": "Land"
        },
        {
            "model": "2FAEZ",
            "serialNumber": "BZQ5SCLFD70M4JI",
            "manufacturedDate": "2022-05-30T17:17:29.763226+00:00",
            "category": "Land"
        },
        {
            "model": "35AUH",
            "serialNumber": "7CWN1O02EHHDVT1",
            "manufacturedDate": "2022-06-22T17:17:29.7632486+00:00",
            "category": "Flying"
        },
        {
            "model": "3TZ5J",
            "serialNumber": "EXC6ADU3JJ86F3M",
            "manufacturedDate": "2022-05-14T17:17:29.7631901+00:00",
            "category": "Flying"
        },
        {
            "model": "4FO45",
            "serialNumber": "8AKTKIDR3UHF6I0",
            "manufacturedDate": "2022-05-18T17:17:29.7631942+00:00",
            "category": "Land"
        },
        {
            "model": "5358K",
            "serialNumber": "YJRSG1BNRJ2KPQZ",
            "manufacturedDate": "2022-05-23T17:17:29.7631989+00:00",
            "category": "Flying"
        },
        {
            "model": "60XP8",
            "serialNumber": "MTZUZNR7E6Y3D5P",
            "manufacturedDate": "2022-05-24T17:17:29.7632198+00:00",
            "category": "Land"
        },
        {
            "model": "6M01F",
            "serialNumber": "22MN1SND7K6Q3EP",
            "manufacturedDate": "2022-05-27T17:17:29.7632231+00:00",
            "category": "Land"
        },
        {
            "model": "6QRFJ",
            "serialNumber": "ZEO9WK66WMAKL8O",
            "manufacturedDate": "2022-06-10T17:17:29.7632367+00:00",
            "category": "Flying"
        },
        {
            "model": "6X1JK",
            "serialNumber": "1DQNDM5EZUPJC98",
            "manufacturedDate": "2022-06-01T17:17:29.763228+00:00",
            "category": "Flying"
        },
        {
            "model": "7KHVZ",
            "serialNumber": "Y7JU3CEC2CN3CJ7",
            "manufacturedDate": "2022-06-18T17:17:29.7632446+00:00",
            "category": "Land"
        },
        {
            "model": "7RVUP",
            "serialNumber": "S1L4O7DIKHBQ1CB",
            "manufacturedDate": "2022-06-07T17:17:29.7632339+00:00",
            "category": "Flying"
        },
        {
            "model": "8LM80",
            "serialNumber": "8NDCESDDPN91J0O",
            "manufacturedDate": "2022-06-13T17:17:29.7632397+00:00",
            "category": "Flying"
        },
        {
            "model": "94F0T",
            "serialNumber": "SCJKB95YUJWC3UX",
            "manufacturedDate": "2022-05-15T17:17:29.7631912+00:00",
            "category": "Land"
        },
        {
            "model": "ALJL3",
            "serialNumber": "WGRVG21BBO6VQ9F",
            "manufacturedDate": "2022-06-21T17:17:29.7632476+00:00",
            "category": "Land"
        },
        {
            "model": "ARGOW",
            "serialNumber": "KBK8K4B4DDFLYE6",
            "manufacturedDate": "2022-06-23T17:17:29.7632558+00:00",
            "category": "Land"
        },
        {
            "model": "AW1GT",
            "serialNumber": "OWK4YFI94LU1U4Q",
            "manufacturedDate": "2022-06-08T17:17:29.7632349+00:00",
            "category": "Land"
        },
        {
            "model": "BO6HU",
            "serialNumber": "DQYY95RHZ67A79C",
            "manufacturedDate": "2022-05-19T17:17:29.7631951+00:00",
            "category": "Land"
        },
        {
            "model": "BSQZ6",
            "serialNumber": "YC541AORWTYR3CC",
            "manufacturedDate": "2022-06-12T17:17:29.7632387+00:00",
            "category": "Land"
        },
        {
            "model": "CMFK8",
            "serialNumber": "QKG4FIFZTIB0UI2",
            "manufacturedDate": "2022-06-06T17:17:29.7632329+00:00",
            "category": "Land"
        },
        {
            "model": "CO25B",
            "serialNumber": "H6JAX5DVGZBC52V",
            "manufacturedDate": "2022-05-17T17:17:29.7631931+00:00",
            "category": "Flying"
        },
        {
            "model": "E48JA",
            "serialNumber": "R46K5ZYEEUZFS87",
            "manufacturedDate": "2022-06-14T17:17:29.7632406+00:00",
            "category": "Land"
        },
        {
            "model": "EQ3HP",
            "serialNumber": "4894X4JK3DFBIAE",
            "manufacturedDate": "2022-06-16T17:17:29.7632426+00:00",
            "category": "Flying"
        },
        {
            "model": "EU633",
            "serialNumber": "JEIUV9HUBJTDZ0M",
            "manufacturedDate": "2022-05-26T17:17:29.7632221+00:00",
            "category": "Flying"
        },
        {
            "model": "F2Y42",
            "serialNumber": "KAYKBSSGEODHY0A",
            "manufacturedDate": "2022-05-13T17:17:29.7631879+00:00",
            "category": "Land"
        },
        {
            "model": "FLWTQ",
            "serialNumber": "XDL4V9V1HMVUWYO",
            "manufacturedDate": "2022-06-02T17:17:29.763229+00:00",
            "category": "Land"
        },
        {
            "model": "G1X07",
            "serialNumber": "RVQGQLBVY24FWKP",
            "manufacturedDate": "2022-06-17T17:17:29.7632436+00:00",
            "category": "Land"
        },
        {
            "model": "G3JUS",
            "serialNumber": "BBKYQJ3EUZUEVL9",
            "manufacturedDate": "2022-05-05T17:17:29.7631777+00:00",
            "category": "Flying"
        },
        {
            "model": "HW0ZO",
            "serialNumber": "1V1VS5GXBUPIGJ1",
            "manufacturedDate": "2022-05-20T17:17:29.763196+00:00",
            "category": "Flying"
        },
        {
            "model": "I4NBF",
            "serialNumber": "6MBLZX88SHF7T5X",
            "manufacturedDate": "2022-05-08T17:17:29.7631827+00:00",
            "category": "Flying"
        },
        {
            "model": "IM58F",
            "serialNumber": "15N3MCOH4IM00CB",
            "manufacturedDate": "2022-05-31T17:17:29.763227+00:00",
            "category": "Land"
        },
        {
            "model": "IR3NM",
            "serialNumber": "2XVAI9P8UG5UBBI",
            "manufacturedDate": "2022-06-19T17:17:29.7632456+00:00",
            "category": "Flying"
        },
        {
            "model": "L6SWO",
            "serialNumber": "M3G7WKNRDIA7FW2",
            "manufacturedDate": "2022-05-06T17:17:29.7631806+00:00",
            "category": "Land"
        },
        {
            "model": "L83ZJ",
            "serialNumber": "6KCJT7ICX8DND7J",
            "manufacturedDate": "2022-06-15T17:17:29.7632416+00:00",
            "category": "Land"
        },
        {
            "model": "O31TQ",
            "serialNumber": "EKWEFL00TYR6TSE",
            "manufacturedDate": "2022-05-10T17:17:29.7631849+00:00",
            "category": "Land"
        },
        {
            "model": "OVBBS",
            "serialNumber": "K3WL2TL4C053IWI",
            "manufacturedDate": "2022-06-05T17:17:29.763232+00:00",
            "category": "Land"
        },
        {
            "model": "Q073S",
            "serialNumber": "BHE180K9RU72633",
            "manufacturedDate": "2022-05-09T17:17:29.7631838+00:00",
            "category": "Land"
        },
        {
            "model": "QNX7Z",
            "serialNumber": "WQH82TVZU1FGP97",
            "manufacturedDate": "2022-05-25T17:17:29.763221+00:00",
            "category": "Land"
        },
        {
            "model": "R152D",
            "serialNumber": "VDX1MCJUL3YZO73",
            "manufacturedDate": "2022-05-29T17:17:29.7632251+00:00",
            "category": "Flying"
        },
        {
            "model": "RH9XD",
            "serialNumber": "G02BB5LT3UHSGHS",
            "manufacturedDate": "2022-06-11T17:17:29.7632377+00:00",
            "category": "Land"
        },
        {
            "model": "RMVUP",
            "serialNumber": "0626XHH6FTOYH22",
            "manufacturedDate": "2022-05-21T17:17:29.763197+00:00",
            "category": "Land"
        },
        {
            "model": "RYCGD",
            "serialNumber": "Z4FEQY4YHV4AGKX",
            "manufacturedDate": "2022-05-22T17:17:29.763198+00:00",
            "category": "Land"
        },
        {
            "model": "SHWM3",
            "serialNumber": "MAXLIBQYXB13FXA",
            "manufacturedDate": "2022-05-28T17:17:29.7632241+00:00",
            "category": "Land"
        },
        {
            "model": "TM6NO",
            "serialNumber": "G92VPBCMMHPR3J6",
            "manufacturedDate": "2022-06-20T17:17:29.7632466+00:00",
            "category": "Land"
        },
        {
            "model": "W71J8",
            "serialNumber": "7Y65PGB4NA8N9L1",
            "manufacturedDate": "2022-05-16T17:17:29.7631921+00:00",
            "category": "Land"
        },
        {
            "model": "X2W1D",
            "serialNumber": "1E7M94WNUJ0L5TJ",
            "manufacturedDate": "2022-06-04T17:17:29.763231+00:00",
            "category": "Flying"
        },
        {
            "model": "Y9MQI",
            "serialNumber": "F6PLGV8RH2KZPBB",
            "manufacturedDate": "2022-06-09T17:17:29.7632358+00:00",
            "category": "Land"
        },
        {
            "model": "YHKM9",
            "serialNumber": "N9R8KNB0CIX9ONO",
            "manufacturedDate": "2022-05-11T17:17:29.7631859+00:00",
            "category": "Flying"
        },
        {
            "model": "YP909",
            "serialNumber": "GJRJ3DY1E6UBI2W",
            "manufacturedDate": "2022-06-03T17:17:29.76323+00:00",
            "category": "Land"
        }
    ]
}



