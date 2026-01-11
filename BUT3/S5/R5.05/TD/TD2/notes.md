# Big Data - MapReduce Solutions

This document contains the complete solutions for all 8 MapReduce activities.

## Data Analysis Summary

Based on the provided JSON files:

- **Companies**: 687 companies with fields: id, guid, name, abbreviation, description, creation, city, state, country, image
- **Platforms**: 108 platforms with fields: id, guid, name, abbreviation, release, price, company, image

## Solutions Overview

All solutions are implemented in [mapreduce_solutions.md](./mapreduce_solutions.md) with:

- Proper Map and Reduce phase separation
- Error handling for missing/null values  
- Appropriate key-value pair design
- Following the established MapReduce patterns

## Key Implementation Notes

1. **Aggregation operations** (Activities 1, 2, 6, 8): Use counting and comparison logic
2. **Projection operations** (Activities 3, 4): Extract specific fields
3. **Selection operations** (Activity 5): Filter based on conditions  
4. **Global operations** (Activities 7, 8): Use single key to collect all data

Each activity includes both Map and Reduce pseudocode following the example pattern provided in the PDF.

## Notes

- All solutions follow the MapReduce paradigm with distinct Map and Reduce phases
- The Map phase processes individual records and emits key-value pairs
- The Reduce phase aggregates values by key to produce final results
- Error handling for null/missing values is included where necessary
- Date comparisons assume ISO date format (YYYY-MM-DD)
- Price comparisons exclude null, empty, or zero values where appropriate
