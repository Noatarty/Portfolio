# MapReduce Solutions - Big Data TD

## Activity 1: Number of companies per country

Map Phase

```pseudocode
inKey: numLine
inValue: line (company)
outKey: country
outValue: 1

Mapper(inKey, inValue):
    if (numLine != firstLine):
        company = parseJSON(inValue)
        if (company.country != null):
            outKey = company.country
            outValue = 1
            emitIntermediate(outKey, outValue)
```

Reduce Phase

```pseudocode
inKey: country
inValue: list of 1
outKey: country
outValue: number of companies in the country

Reduce(inKey, inValue):
    sum = 0
    foreach element in inValue:
        sum++
    outValue = sum
    emit(outKey, outValue)
```

## Activity 2: Number of platforms per company

Map Phase

```pseudocode
inKey: numLine
inValue: line (platform)
outKey: companyId
outValue: 1

Mapper(inKey, inValue):
    if (numLine != firstLine):
        platform = parseJSON(inValue)
        if (platform.company != null):
            outKey = platform.company
            outValue = 1
            emitIntermediate(outKey, outValue)
```

Reduce Phase

```pseudocode
inKey: companyId
inValue: list of 1
outKey: companyId
outValue: number of platforms for the company

Reduce(inKey, inValue):
    sum = 0
    foreach element in inValue:
        sum++
    outValue = sum
    emit(outKey, outValue)
```

## Activity 3: Project - Name of the companies

Map Phase

```pseudocode
inKey: numLine
inValue: line (company)
outKey: id
outValue: name

Mapper(inKey, inValue):
    if (numLine != firstLine):
        company = parseJSON(inValue)
        outKey = company.id
        outValue = company.name
        emitIntermediate(outKey, outValue)
```

Reduce Phase

```pseudocode
inKey: id
inValue: list of names (should be single name)
outKey: id
outValue: name

Reduce(inKey, inValue):
    outValue = inValue[0]
    emit(outKey, outValue)
```

## Activity 4: Project - Name of the platforms

Map Phase

```pseudocode
inKey: numLine
inValue: line (platform)
outKey: id
outValue: name

Mapper(inKey, inValue):
    if (numLine != firstLine):
        platform = parseJSON(inValue)
        outKey = platform.id
        outValue = platform.name
        emitIntermediate(outKey, outValue)
```

Reduce Phase

```pseudocode
inKey: id
inValue: list of names (should be single name)
outKey: id
outValue: name

Reduce(inKey, inValue):
    outValue = inValue[0]
    emit(outKey, outValue)
```

## Activity 5: Selection - Platform with price greater than 300$

Map Phase

```pseudocode
inKey: numLine
inValue: line (platform)
outKey: id
outValue: platform_info

Mapper(inKey, inValue):
    if (numLine != firstLine):
        platform = parseJSON(inValue)
        if (platform.price != null && parseInt(platform.price) > 300):
            outKey = platform.id
            outValue = platform
            emitIntermediate(outKey, outValue)
```

Reduce Phase

```pseudocode
inKey: id
inValue: list of platform_info (should be single platform)
outKey: id
outValue: platform_info

Reduce(inKey, inValue):
    outValue = inValue[0]
    emit(outKey, outValue)
```

## Activity 6: Aggregation and comparison - Oldest companies per country

Map Phase

```pseudocode
inKey: numLine
inValue: line (company)
outKey: country
outValue: (creation_date, company_info)

Mapper(inKey, inValue):
    if (numLine != firstLine):
        company = parseJSON(inValue)
        if (company.country != null && company.creation != null):
            outKey = company.country
            outValue = (company.creation, company)
            emitIntermediate(outKey, outValue)
```

Reduce Phase

```pseudocode
inKey: country
inValue: list of (creation_date, company_info)
outKey: country
outValue: oldest_company_info

Reduce(inKey, inValue):
    oldestDate = null
    oldestCompany = null
    
    foreach (date, company) in inValue:
        if (oldestDate == null || date < oldestDate):
            oldestDate = date
            oldestCompany = company
    
    outValue = oldestCompany
    emit(outKey, outValue)
```

## Activity 7: Comparison - Newest companies

Map Phase

```pseudocode
inKey: numLine
inValue: line (company)
outKey: "all"
outValue: (creation_date, company_info)

Mapper(inKey, inValue):
    if (numLine != firstLine):
        company = parseJSON(inValue)
        if (company.creation != null):
            outKey = "all"
            outValue = (company.creation, company)
            emitIntermediate(outKey, outValue)
```

Reduce Phase

```pseudocode
inKey: "all"
inValue: list of (creation_date, company_info)
outKey: "newest_company"
outValue: newest_company_info

Reduce(inKey, inValue):
    newestDate = null
    newestCompany = null
    
    foreach (date, company) in inValue:
        if (newestDate == null || date > newestDate):
            newestDate = date
            newestCompany = company
    
    outValue = newestCompany
    emit(outKey, outValue)
```

## Activity 8: Aggregation - Cheapest platform

Map Phase

```pseudocode
inKey: numLine
inValue: line (platform)
outKey: "all"
outValue: (price, platform_info)

Mapper(inKey, inValue):
    if (numLine != firstLine):
        platform = parseJSON(inValue)
        if (platform.price != null && platform.price != "0" && platform.price != ""):
            outKey = "all"
            outValue = (parseInt(platform.price), platform)
            emitIntermediate(outKey, outValue)
```

Reduce Phase

```pseudocode
inKey: "all"
inValue: list of (price, platform_info)
outKey: "cheapest_platform"
outValue: cheapest_platform_info

Reduce(inKey, inValue):
    minPrice = null
    cheapestPlatform = null
    
    foreach (price, platform) in inValue:
        if (minPrice == null || price < minPrice):
            minPrice = price
            cheapestPlatform = platform
    
    outValue = cheapestPlatform
    emit(outKey, outValue)
```
