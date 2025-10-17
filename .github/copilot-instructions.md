# Copilot instructions for WebAnw-Projekt

This repository contains small demo Spring Boot applications used for teaching/exploration. The guidance below is focused and actionable for an AI coding agent working in this workspace.

High-level structure
- Two independent Spring Boot modules at the repo root:
  - `Sino/` — Spring Boot  application (main class: `edu.fra.uas.sino.SinoApplication`)
  - `Altaystest/` — Spring Boot application (main class: `edu.fra.uas.Altaystest.AltaystestApplication`)
- Each module is a standalone Maven project with its own `pom.xml`, `mvnw`, and `src/` tree. There is no parent multi-module pom.

Why this matters
- Treat each folder as an independent service when making changes: build, run, and test commands operate per-module.
- Keep changes localized to one module unless the change explicitly requires edits in the other (examples: shared packaging, moving common code).

Build / run / test (Windows PowerShell examples)
- Build a single module (from repo root):
  ```powershell
  ./Sino/mvnw -f ./Sino/pom.xml clean package
  ./Altaystest/mvnw -f ./Altaystest/pom.xml clean package
  ```
- Run the application locally (devtools is included):
  ```powershell
  ./Sino/mvnw -f ./Sino/pom.xml spring-boot:run
  ./Altaystest/mvnw -f ./Altaystest/pom.xml spring-boot:run
  ```
- Run tests:
  ```powershell
  ./Sino/mvnw -f ./Sino/pom.xml test
  ./Altaystest/mvnw -f ./Altaystest/pom.xml test
  ```

Project conventions and patterns (discoverable)
- Java: source packages follow `edu.fra.uas.<ModuleName>` and main classes are named `<ModuleName>Application`.
- Configuration: minimal `application.properties` present under `src/main/resources` (e.g. `Altaystest/src/main/resources/application.properties`).
- Dependencies: both modules use Spring Boot 4.0.0-M3 and Java 17 per module `pom.xml`.
- Tests: modules include a single smoke test `*ApplicationTests` using `@SpringBootTest`.

Integration points & external dependencies
- There are no external services or 3rd-party integration credentials stored in the repo. If adding integrations, follow Spring Boot conventions (properties in `application.properties`) and do not hardcode secrets.

Change guidelines for AI agents
- Small, focused commits: when editing code, limit changes to the module that requires them. Mention the module name in commit messages (e.g., `Sino: add controller for X`).
- When adding dependencies, update only that module's `pom.xml` and run `./<module>/mvnw -f ./<module>/pom.xml test` locally.
- Prefer adding a minimal unit or integration test alongside behaviour changes (the repo already uses JUnit 5/Spring Boot Test).

Examples from the codebase
- To add a new REST controller in `Sino` place it under `Sino/src/main/java/edu/fra/uas/sino/controller/` and annotate with `@RestController`.
- The main application entry is `Sino/src/main/java/edu/fra/uas/sino/SinoApplication.java` and `Altaystest/src/main/java/edu/fra/uas/Altaystest/AltaystestApplication.java`.

Files to inspect when making changes
- `Sino/pom.xml`, `Altaystest/pom.xml` — dependency and build plugin references
- `src/main/resources/application.properties` — runtime properties
- `src/test/java/**/*ApplicationTests.java` — existing smoke tests to copy when adding tests

When unsure, prefer the safe action
- Keep builds passing: run the module's tests before proposing larger cross-module changes.
- If a change touches build configuration (pom), run a `clean package` to validate.

If anything here is unclear or you'd like the instructions to be more or less strict (for example, to follow a multi-module parent pom), tell me what to change and I'll iterate.
