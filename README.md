# PDX Transformer

A Java-based tool for transforming provider-specific database schemas into the standardized data model used by PDX Finder. This transformation ensures that diverse data sources can be harmonized and integrated into the PDX Finder platform.

## 🔍 Overview

The PDX Transformer is a component of the PDX Finder project, which aggregates clinical, genomic, and functional data from patient-derived xenograft (PDX) models to support cancer research. By converting various provider data schemas into a unified format, the transformer facilitates consistent data integration and analysis.

## 📁 Project Structure

- `src/`: Contains the main Java source code for the transformer.
- `target/classes/templates/`: Directory for compiled templates and resources.
- `pom.xml`: Maven project configuration file.

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven 3.6 or higher

### Building the Project

```bash
git clone https://github.com/PDCMFinder/pdx-transformer.git
cd pdx-transformer
mvn clean install
