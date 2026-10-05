# Health Tracker Companion — Development Framework

## Purpose
Health Tracker Companion is a **personal, single-user Android shortcut/notification helper** built specifically to reduce the friction of entering updates into Damien's existing ChatGPT Health Tracker Project.

It is not a second Health Tracker and should not duplicate the intelligence already working in ChatGPT.

## Roles
### ChatGPT — Architect / Health Tracker intelligence
- defines requirements and small implementation tasks
- remains the conversational health-tracking interface
- understands Damien's natural-language entries and Project context
- manages the existing Health Tracker GitHub records through the current workflow
- reviews whether additional Android functionality is actually necessary

### Codex — Builder
- implements only the approved Android helper scope
- prefers the smallest reliable Android implementation
- tests and documents actual Android/ChatGPT routing behaviour
- does not add AI, GitHub sync, Health Connect or product infrastructure unless explicitly approved later
- reports limitations rather than inventing unsupported integrations

### GitHub — durable source of truth
Stores Health Tracker records, project specifications and Companion source/version history.

## Core development rule
> Do not rebuild what already works in ChatGPT. Reduce the taps required to reach it.

## Current implementation target
A tiny sideloaded Android APK/helper whose first job is:

`Android notification -> Update Health Tracker button -> ChatGPT -> existing Health Tracker workflow`

The APK may contain a minimal setup/test activity, but normal daily use should not require opening it.

## Phase 1 only
Build:
- basic Android project
- notification permission handling
- Health Tracker notification channel
- test notification
- `Update Health Tracker` action
- supported intent/deep-link launch into ChatGPT
- investigation/documentation of whether the specific Project/chat can be targeted reliably

Do not build:
- Health Connect
- Samsung Health import
- AI/LLM integration
- direct GitHub writes
- GitHub authentication
- natural-language interpretation
- food logic
- database/queue
- workout detection
- dashboard
- background health processing

## Routing rule
Use supported Android/ChatGPT mechanisms only. Do not reverse-engineer private ChatGPT APIs or automate undocumented authenticated message submission.

If Android can open ChatGPT but cannot reliably target this specific Project/chat, implement the closest stable route and clearly document the remaining manual tap(s).

## Development workflow
1. ChatGPT defines a narrow outcome and acceptance criteria.
2. Codex inspects these Companion documents before coding.
3. Codex implements the smallest complete change.
4. Build a debug APK.
5. Test on Damien's real Samsung phone.
6. Record what actually happens when the notification action is pressed.
7. Adjust only after observing the real workflow.

## First milestone
> Install a minimal APK on Damien's Samsung phone, display a `Health Tracker Update` notification, press `Update Health Tracker`, and establish the closest reliable supported route into the existing ChatGPT Health Tracker workflow.

That is the complete first milestone.
